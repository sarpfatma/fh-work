import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TranslateModule } from '@ngx-translate/core';

import { CoreModule } from '@core';
import { SharedModule } from '@shared';
import { TransactionsRoutingModule } from './transaction_detail-routing.module';
import { TransactionDetailComponent } from './transaction_detail.component';
import { TransactionDetailService } from './transaction_detail.service';
import {ReactiveFormsModule} from "@angular/forms";

@NgModule({
  imports: [CommonModule, TranslateModule, CoreModule, SharedModule, TransactionsRoutingModule, ReactiveFormsModule],
  declarations: [TransactionDetailComponent],
})
export class TransactionDetailModule {}
