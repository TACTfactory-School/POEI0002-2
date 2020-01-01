import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'ago'
})
export class AgoPipe implements PipeTransform {

  convert(par1: number, par2: number, par3: string): string {
    const nb = Number.parseInt(`${par1 / par2}`, 10);
    let s = '';
    if (nb > 1) {
      s = 's';
    }
    return nb.toString() + ' ' + par3 + s;
  }
  transform(value: string): any {
    let res: string;
    let nb;
    const minute = 60 * 1000;
    const heure = 60 * minute;
    const jour = 24 * heure;
    const semaine = 7 * jour;
    const mois = 30 * jour;
    const annee = 365 * jour;
    const eventStartTime = new Date(value);
    let diff = eventStartTime.valueOf() - (new Date().valueOf());
    const passt = diff < 0;
    if (passt) {
      diff = diff * -1;
    }
    if (diff > annee) {
      res = this.convert(diff, annee, 'an');
    } else if (diff > mois) {
      nb = Number.parseInt(`${diff / mois}`, 10);
      res = nb.toString() + `  mois`;
    } else if (diff > semaine) {
      res = this.convert(diff, semaine, 'semaine');
    } else if (diff > jour) {
      res = this.convert(diff, jour, 'jour');
    } else if (diff > heure) {
      res = this.convert(diff, heure, 'heure');
    } else if (diff > minute) {
      res = this.convert(diff, minute, 'minute');
    } else {
      res = this.convert(diff, 1000, 'second');
    }

    if (passt) {
      return 'il y a ' + res;
    } else {
      return 'dans ' + res;
    }
  }

}
