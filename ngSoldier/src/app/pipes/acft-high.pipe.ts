import { Pipe, PipeTransform } from '@angular/core';
import { Soldier } from '../models/soldier';

@Pipe({
  name: 'acftHigh',
  standalone: true
})
export class AcftHighPipe implements PipeTransform {

  transform(soldiers : Soldier[], acftScore : number): Soldier[] {
   const newList : Soldier[] = [];
    for (const soldier of soldiers){
      //Need to build out Acft class before I can do this
    }
    return newList;
  }

}
