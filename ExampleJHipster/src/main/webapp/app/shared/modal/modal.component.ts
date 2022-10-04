import { Component } from '@angular/core';
import { MdbModalRef } from 'mdb-angular-ui-kit/modal';
import { IStudent } from '../../entities/student/student.model';
import { StudentService } from '../../admin/Student-management/student.service';
import { DataServiceService } from '../data-service.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-modal',
  templateUrl: './modal.component.html',
})
export class ModalComponent {
  title: string = '';
  Student: IStudent | null = null;
  studentUpdate: IStudent | null = null;
  titleUpdate: string = 'Update Information Student';
  titleCreate: string = 'Create New Student';
  titleDelete: String = 'Delete Student';

  constructor(
    public modalRef: MdbModalRef<ModalComponent>,
    private studentService: StudentService,
    private dataService: DataServiceService
  ) {}

  saveModal(value: string, value2: string, value3: string) {
    if (value == '' || value2 == '' || value3 == '') Swal.fire('Waring', 'Please Input Information Of Student!', 'warning');
    else {
      this.Student = { name: value, clazz: value2, score: Number(value3) };
      this.studentService.create(this.Student).subscribe((data: any) => {
        this.dataService.changeStudent(data);
        Swal.fire('Create New Student Success!', 'Done!!!', 'success'), this.modalRef.close();
      });
    }
  }

  UpdateModal(maSv: number, value: string, value2: string, value3: string) {
    if (value == '' || value2 == '' || value3 == '') Swal.fire('Waring', 'Please Input Information Of Student!', 'warning');
    else {
      this.studentUpdate = { name: value, clazz: value2, score: Number(value3) };
      this.studentService.update(maSv, this.studentUpdate).subscribe((data: any) => {
        this.dataService.changeStudentUpdate(data);
      });
      Swal.fire('Update Student Success!', 'Done!!!', 'success');
      this.modalRef.close();
    }
  }
}
