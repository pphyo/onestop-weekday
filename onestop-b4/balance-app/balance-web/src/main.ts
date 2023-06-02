import { bootstrapApplication } from '@angular/platform-browser';
import { AppComponent } from './app/app.component';
import { provideRouter } from '@angular/router';
import { RecordsComponent } from './app/pages/records/records.component';
import { BudgetsComponent } from './app/pages/budgets/budgets.component';
import { AccountsComponent } from './app/pages/accounts/accounts.component';
import { CategoriesComponent } from './app/pages/categories/categories.component';
import { CategoryEditFormComponent } from './app/utils/widgets/category/category-edit-form/category-edit-form.component';
import { importProvidersFrom } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

bootstrapApplication(AppComponent, {
  providers: [
    provideRouter([
      {path: 'records', component: RecordsComponent},
      {path: 'budgets', component: BudgetsComponent},
      {path: 'accounts', component: AccountsComponent},
      {path: 'categories', component: CategoriesComponent},
      {path: 'categories/edit-form', component: CategoryEditFormComponent},
      {path: '', redirectTo: '/records', pathMatch: 'full'}
    ]),
    importProvidersFrom(HttpClientModule)
  ]
})
  .catch((err) => console.error(err));
