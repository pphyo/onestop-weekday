import { bootstrapApplication } from '@angular/platform-browser';
import { AppComponent } from './app/app.component';
import { ResolveFn, Route, provideRouter } from '@angular/router';
import { RecordsComponent } from './app/pages/records/records.component';
import { BudgetsComponent } from './app/pages/budgets/budgets.component';
import { AccountsComponent } from './app/pages/accounts/accounts.component';
import { CategoriesComponent } from './app/pages/categories/categories.component';
import { CategoryEditFormComponent } from './app/utils/widgets/category/category-edit-form/category-edit-form.component';
import { importProvidersFrom } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

const record:ResolveFn<string> = () => Promise.resolve('Record')

const routes:Route[] = [
  {path: 'records', component: RecordsComponent, title: record},
  {path: 'budgets', component: BudgetsComponent, title: 'Balance | Budget'},
  {path: 'accounts', component: AccountsComponent, title: 'Balance | Account'},
  {path: 'categories', component: CategoriesComponent, title: 'Balance | Category'},
  {path: 'categories/edit-form', component: CategoryEditFormComponent, title: 'Balance | Category Form'},
  {path: '', redirectTo: '/records', pathMatch: 'full'}
]

bootstrapApplication(AppComponent, {
  providers: [
              provideRouter(routes),
              importProvidersFrom(HttpClientModule)
             ]
})
  .catch((err) => console.error(err));
