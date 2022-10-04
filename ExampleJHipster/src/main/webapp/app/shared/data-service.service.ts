import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { IStudent } from '../entities/student/student.model';

@Injectable({
  providedIn: 'root',
})
export class DataServiceService {
  private StudentCreate = new BehaviorSubject<IStudent>({ clazz: '', name: '', score: 0 });
  private studentUpdate = new BehaviorSubject<IStudent>({ clazz: '', name: '', score: 0 });

  currentStudentCreate = this.StudentCreate.asObservable();
  currentStudentUpdate = this.studentUpdate.asObservable();

  constructor() {}

  changeStudent = (Student: IStudent) => {
    this.StudentCreate.next(Student);
  };

  changeStudentUpdate = (Student: IStudent) => {
    this.studentUpdate.next(Student);
  };
}
