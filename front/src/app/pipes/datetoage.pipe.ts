import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'datetoage'
})
export class DatetoagePipe implements PipeTransform {

  transform(birthdate: string[]): number {
    const birthdateformated = birthdate[0] + '-' + birthdate[1] + '-' + birthdate[2];
    const newDate = new Date(birthdateformated);
    console.log(newDate);
    const timeDiff = Math.abs(Date.now() - newDate.getTime());
    const age = Math.floor((timeDiff / (1000 * 3600 * 24)) / 365.25);
    return age;
  }
}
