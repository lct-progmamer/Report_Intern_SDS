import { Component, ElementRef, OnInit } from '@angular/core';
import { IStudent } from '../../entities/student/student.model';
import { StudentService } from './student.service';
import { ITEMS_PER_PAGE } from '../../config/pagination.constants';
import Swal from 'sweetalert2';
import { ModalComponent } from '../../shared/modal/modal.component';
import { MdbModalRef, MdbModalService } from 'mdb-angular-ui-kit/modal';
import { DataServiceService } from '../../shared/data-service.service';

@Component({
  selector: 'jhi-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.scss'],
})
export class StudentListComponent implements OnInit {
  students: IStudent[] | null = null;
  pageIndex: number = 0;
  search: string = '';
  sort: string = 'maSv';
  isSort: string = 'asc';
  sortBy: boolean = true;
  pageSize = ITEMS_PER_PAGE;
  totalStudents: number = 0;
  // @ts-ignore
  studentCreate: IStudent = null;
  isPaginationShow: boolean = true;
  minId: number = 0;
  maxId: number = 0;
  listDelete: Number[] = [];
  isLoading: boolean = false;

  modalRef: MdbModalRef<ModalComponent> | null = null;

  constructor(private serivce: StudentService, private modalService: MdbModalService, private dataSerivce: DataServiceService) {}

  ngOnInit(): void {
    this.getAll(this.pageIndex, this.search, this.sort, this.isSort, this.minId, this.maxId);
  }

  getAll = (page?: number, search?: string, sort?: string, isSort?: string, minId?: number, maxId?: number) => {
    this.isLoading = true;
    if (this.sortBy == true) {
      this.isSort = 'asc';
    } else {
      this.isSort = 'desc';
    }
    console.log(this.isSort + ' , ' + this.sort);
    this.isPaginationShow = true;

    this.serivce.getAll(page, search, sort, isSort, minId, maxId).subscribe({
      next: (data: any) => {
        this.students = data.content;
        this.totalStudents = Number(data.totalElements);
        this.isLoading = false;
      },
      error: message => {
        this.isLoading = false;
      },
    });
  };

  deleteStudent(maSv: number) {
    Swal.fire({
      title: 'Are you sure?',
      text: '',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Yes, delete it!',
    }).then(result => {
      if (result.isConfirmed) {
        this.serivce.deleteStudent(maSv).subscribe((data: any) => {
          Swal.fire('Deleted!', 'Your file has been deleted.', 'success');
          // @ts-ignore
          this.students = this.students?.filter((item: IStudent) => {
            return item.maSv != maSv;
          });
        });
      }
    });
  }

  pagination(e: number) {
    this.pageIndex = e - 1;
    this.getAll(this.pageIndex, this.search, this.sort, this.isSort, this.minId, this.maxId);
  }

  openModal() {
    this.modalRef = this.modalService.open(ModalComponent);
    this.modalRef.onClose.subscribe((message: any) => {
      this.dataSerivce.currentStudentCreate.subscribe(data => (this.studentCreate = data));
      this.pageIndex = Math.ceil(this.totalStudents / this.pageSize) - 1;
      this.getAll(this.pageIndex, this.search, this.sort, this.isSort);
    });
  }

  SearchStudent(value: string) {
    if (value == '') Swal.fire('Waring', 'Please Input Student Name Need To Search!!!', 'warning');
    else {
      this.search = value;
      this.isPaginationShow = false;
      this.serivce.searchStudent(this.search).subscribe((data: any) => {
        this.students = data.content;

        this.totalStudents = Number(data.totalElements);
      });
    }
    this.search = '';
  }

  filterStudent(value: string, value2: string) {
    this.minId = Number(value);
    this.maxId = Number(value2);
    this.getAll(this.pageIndex, this.search, this.sort, this.isSort, this.minId, this.maxId);
  }

  reload() {
    this.getAll(0, '', this.sort, this.isSort, 0, 0);
    this.search = '';
    this.minId = 0;
    this.maxId = 0;
  }

  openModalUpdate(student: IStudent) {
    this.modalRef = this.modalService.open(ModalComponent, {
      data: { studentUpdate: student },
    });
    this.modalRef.onClose.subscribe(() => {
      this.getAll(this.pageIndex, this.search, this.sort, this.isSort, this.minId, this.maxId);
    });
  }

  deleteMulti() {
    console.log(this.listDelete);
    if (this.listDelete.length == 0) {
      Swal.fire('Warning', 'Please choose student need to delete !!!', 'warning');
    } else {
      Swal.fire({
        title: 'Are you sure?',
        text: '',
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Yes, delete them!',
      }).then(result => {
        if (result.isConfirmed) {
          this.serivce.deleteMul(this.listDelete).subscribe((data: any) => {
            if (data) {
              Swal.fire('Done!', 'Deleted Success!', 'success');
              this.getAll(this.pageIndex, this.search, this.sort, this.isSort, this.minId, this.maxId);
            }
          });
        }
        this.listDelete = [];
      });
    }
  }

  // @ts-ignore
  checkDelete = (e: Event): Number => {
    // @ts-ignore
    if (e.target.checked) {
      // @ts-ignore
      this.listDelete.push(Number(e.target.defaultValue));
    }
    // @ts-ignore
    if (e.target.checked == false) {
      this.listDelete = this.listDelete.filter(item => {
        // @ts-ignore
        return item != Number(e.target.defaultValue);
      });
    }
  };

  Sort(e: MouseEvent) {
    if (this.sortBy == true) this.sortBy = false;
    else {
      this.sortBy = true;
    }

    // @ts-ignore
    this.sort = e.srcElement.id;
    this.getAll(this.pageIndex, this.search, this.sort, this.isSort, this.minId, this.maxId);
    this.sort = 'maSv';
  }
}
