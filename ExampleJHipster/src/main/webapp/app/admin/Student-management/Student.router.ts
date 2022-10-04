import { Route } from '@angular/router';
import { StudentListComponent } from './student-list.component';

export const StudentRouter: Route = {
  path: '',
  component: StudentListComponent,
  data: {
    pageTitle: 'students',
  },
};
