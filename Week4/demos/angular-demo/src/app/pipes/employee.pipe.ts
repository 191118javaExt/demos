import { Pipe, PipeTransform } from '@angular/core';
import { User } from '../models/user';
import { DatePipe } from '@angular/common';

@Pipe({
  name: 'employee'
})
export class EmployeePipe implements PipeTransform {

  date: DatePipe = new DatePipe('en-US');

  transform(value: Array<User>, text: string): any {
    text = text.toLowerCase();
    return value.filter( (elem: User) => {
      let include: boolean = false;

      if(('' + elem.id).includes(text)) {
        include = true;
      }

      if(elem.firstName.toLowerCase().includes(text)) {
        include = true;
      }

      if(elem.lastName.toLowerCase().includes(text)) {
        include = true;
      }

      if(elem.username.toLowerCase().includes(text)) {
        include = true;
      }

      if(this.date.transform(elem.hireDate.toLowerCase(), 'full').includes(text)) {
        include = true;
      }

      return include;
    })
  }

}
