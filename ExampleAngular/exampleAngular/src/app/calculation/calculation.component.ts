import { Component, OnInit } from '@angular/core';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-calculation',
  templateUrl: './calculation.component.html',
  styleUrls: ['./calculation.component.css']
})
export class CalculationComponent implements OnInit {
  add: number = 0;
  sub: number = 0;
  mul: number = 0;
  div: number = 0;

  constructor() { }

  ngOnInit(): void {
  }

  checkError = (num1: string, num2: string) => {
    if(num1 == '' || num2 == '')
      return false;
    return true;
  }

  Add(num1: string, num2: string) {
    if(this.checkError(num1 , num2)){
      this.add = Number(num1) + Number(num2);
    }else{
      Swal.fire("ERROR!!!" , "Please Input Value" , "error");
    }
  }

  Sub(value: string, value2: string) {
    if(this.checkError(value , value2)){
      this.sub = Number(value) - Number(value2);
    }
    else{
      Swal.fire("ERROR!!!" , "Please Input Value" , "error");
    }
  }

  Multiple(value: string, value2: string) {
    console.log(this.mul);
    if(this.checkError(value , value2)){
      this.mul = Number(value) * Number(value2);
    }
    else{

      Swal.fire("ERROR!!!" , "Please Input Value" , "error");
    }
  }

  Divide(value: string, value2: string) {
    const num2 = Number(value2);
    if(this.checkError(value , value2)){
      if(num2 != 0)
        this.div = Number((Number(value) / num2).toFixed(4));
      else
        Swal.fire("ERROR!!!" , "Number 2 must be other than 0" , "error");
    }
    else{
      Swal.fire("ERROR!!!" , "Please Input Value" , "error");
    }
  }
}
