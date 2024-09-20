import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable, catchError, throwError } from 'rxjs';
import { Soldier } from '../models/soldier';

@Injectable({
  providedIn: 'root'
})
export class SoldierService {

  url = environment.baseUrl + 'api/soldiers'

  constructor(
    private http: HttpClient
  ) { }


index(): Observable<Soldier[]>{
  //Get from Pokemon index
  return this.http.get<Soldier[]>(this.url).pipe(
    catchError(
      (err: any) => {
        console.log(err);
        return throwError(
          () => {return new Error('SoldierService.index(): error retrieving soldier: ' + err)

          }
        );
      }
    )
);

}



}
