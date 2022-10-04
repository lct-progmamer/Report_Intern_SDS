import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SharedModule } from '../../shared/shared.module';
import { RouterModule } from '@angular/router';
import { StudentListComponent } from './student-list.component';
import { StudentRouter } from './Student.router';
import { AppModule } from '../../app.module';

@NgModule({
  declarations: [StudentListComponent],
  imports: [SharedModule, RouterModule.forChild([StudentRouter])],
})
export class StudentModule {}
