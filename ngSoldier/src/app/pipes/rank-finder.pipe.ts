import { Pipe, PipeTransform } from '@angular/core';
import { Soldier } from '../models/soldier';

@Pipe({
  name: 'rankFinder',
  standalone: true
})
export class RankFinderPipe implements PipeTransform {

  transform(soldiers : Soldier[], rank : string): Soldier[] {
    const resultList : Soldier[] =[];
    for (const soldier of soldiers){
      if (soldier.militaryRank === rank){
        resultList.push(soldier);
      }
    }
    return resultList;
  }

}
