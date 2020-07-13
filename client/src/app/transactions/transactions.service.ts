import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable, of} from 'rxjs';
import {map, catchError} from 'rxjs/operators';
import {CredentialsService} from "@app/auth";

const routes = {
  transactions: () => `/transactions/list`,
  transactionDetail: (c: TransactionDetailContext) => `/transactions?transactionId=${c.transactionId}`,
};

export interface TransactionsContext {
  fromDate?: Date;
  toDate?: Date;
  status?: String;
  operation?: String;
  merchantId?: Number;
  acquirerId?: Number;
  paymentMethod?: String;
  errorCode?: String;
}
export interface TransactionDetailContext {
  transactionId:String
}

@Injectable({
  providedIn: 'root',
})
export class TransactionsService {
  constructor(private httpClient: HttpClient, private credentialsService: CredentialsService) {
  }

  getTransactions(context: TransactionsContext): Observable<string> {
    const header = {
      headers: new HttpHeaders()
        .set('Authorization', `Bearer ${btoa(this.credentialsService.credentials.token)}`)
    }

    for (const [key, value] of Object.entries(context)) {
      if (value === 'null' || value === null) delete context[key];
    }

    return this.httpClient.post(routes.transactions(), context, header).pipe(
      map((body: any) => body),
      catchError(() => of('Error, could not load transactions :-('))
    );
  }
}
