import {Component, OnInit} from '@angular/core';
import {finalize} from 'rxjs/operators';
import {TransactionsService} from './transactions.service';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";


@Component({
  selector: 'app-transactions',
  templateUrl: './transactions.component.html',
  styleUrls: ['./transactions.component.scss'],
})
export class TransactionsComponent implements OnInit {
  transactions: [any] | undefined;
  totalItem: undefined;
  isLoading = false;
  filterForm!: FormGroup;

  constructor(private transactionsService: TransactionsService, private formBuilder: FormBuilder) {
    this.createForm();
  }

  ngOnInit() {
    this.get();
  }


  get() {

    this.isLoading = false;

    const get$ = this.transactionsService.getTransactions(this.filterForm.value);

    get$
      .pipe(
        finalize(() => {
          this.isLoading = false;
        })
      )
      .subscribe((response: any) => {
        this.transactions = response.data;
        this.totalItem = response.total;
      });
  }

  private createForm() {
    this.filterForm = this.formBuilder.group({
      fromDate: [new Date(), Validators.required],
      toDate: [new Date(), Validators.required],
      status: [null],
      operation: [null],
      merchantId: [null],
      acquirerId: [null],
      paymentMethod: [null],
      errorCode: [null],

    });
  }
}
