import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { IStudent } from '../../entities/student/student.model';
import { ApplicationConfigService } from '../../core/config/application-config.service';
import { DataServiceService } from '../../shared/data-service.service';

@Injectable({
  providedIn: 'root',
})
export class StudentService {
  constructor(
    private http: HttpClient,
    private applicationConfigService: ApplicationConfigService,
    private dataService: DataServiceService
  ) {}

  private url = this.applicationConfigService.getEndpointFor('/api/students/');

  getAll = (page?: number, search?: string, sort?: string, isSort?: string, minId?: number, maxId?: number): Observable<IStudent[]> => {
    return this.http.get<IStudent[]>(
      this.url +
        'getAll?size=5' +
        '&page=' +
        page +
        '&search=' +
        search +
        '&sort=' +
        sort +
        ',' +
        isSort +
        '&minId=' +
        minId +
        '&maxId=' +
        maxId
    );
  };

  searchStudent = (search: string): Observable<IStudent[]> => {
    return this.http.get<IStudent[]>(this.url + 'getAll?search=' + search);
  };

  deleteStudent = (msv: number): Observable<any> => {
    return this.http.delete<any>(this.url + 'delete/' + msv);
  };

  create = (Student: IStudent): Observable<IStudent> => {
    return this.http.post<IStudent>(this.url + 'create', Student);
  };

  update = (id: number, Student: IStudent): Observable<IStudent> => {
    return this.http.put<IStudent>(this.url + 'update/' + id, Student);
  };

  deleteMul = (ids: Number[]): Observable<any> => {
    return this.http.delete<any>(this.url + 'deleteMul/' + ids);
  };
}
