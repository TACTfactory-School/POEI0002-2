import { Pipe, PipeTransform} from '@angular/core';

@Pipe({
  name: 'datetoage'
})

export class DatetoagePipe implements PipeTransform {

  transform(birthdate: string): number {
    const newDate = new Date(birthdate);
    const timeDiff = Math.abs(Date.now() - newDate.getTime());
    const age = Math.floor((timeDiff / (1000 * 3600 * 24)) / 365.25);
    return age;
  }
}
