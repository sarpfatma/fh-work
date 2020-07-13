import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable, of} from 'rxjs';
import {map, catchError} from 'rxjs/operators';
import {CredentialsService} from "@app/auth";

const routes = {
  transactionDetail: (id: String) => `/transactions?transactionId=${id}`,
};

export interface TransactionDetailContext {
  transactionId: String
}

@Injectable({
  providedIn: 'root',
})
export class TransactionDetailService {
  constructor(private httpClient: HttpClient, private credentialsService: CredentialsService) {
  }


  getTransactionDetail(id: String): Observable<string> {

    const header = {
      headers: new HttpHeaders()
        .set('Authorization', `Bearer ${btoa(this.credentialsService.credentials.token)}`)
    }

    return this.httpClient.get(routes.transactionDetail(id), header).pipe(
      map((body: any) => body),
      catchError(() => of('Error, could not load transaction detail :-('))
    );
  }
}
