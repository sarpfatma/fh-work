import {Component, OnInit} from '@angular/core';
import {finalize} from 'rxjs/operators';
import {TransactionDetailService} from './transaction_detail.service';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute} from "@angular/router";


@Component({
  selector: 'app-transaction-detail',
  templateUrl: './transaction_detail.component.html',
  styleUrls: ['./transaction_detail.component.scss'],
})

export class TransactionDetailComponent implements OnInit {
  transactionId: String | undefined;
  isLoading = false;
  trn: any = null;

  constructor(private transactionDetailService: TransactionDetailService, private route: ActivatedRoute) {
    console.log(route)
  }

  ngOnInit() {

    let id = this.route.snapshot.paramMap.get('transactionId');

    const get$ = this.transactionDetailService.getTransactionDetail(id);

    get$
      .pipe(
        finalize(() => {
          this.isLoading = false;
        })
      )
      .subscribe((response: any) => {
        this.trn = response;
      });
  }

}
