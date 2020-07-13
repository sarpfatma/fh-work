import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TranslateModule } from '@ngx-translate/core';

import { CoreModule } from '@core';
import { SharedModule } from '@shared';
import { TransactionsRoutingModule } from './transactions-routing.module';
import { TransactionsComponent } from './transactions.component';
import { TransactionsService } from './transactions.service';
import {ReactiveFormsModule} from "@angular/forms";

@NgModule({
  imports: [CommonModule, TranslateModule, CoreModule, SharedModule, TransactionsRoutingModule, ReactiveFormsModule],
  declarations: [TransactionsComponent],
})
export class TransactionsModule {}
