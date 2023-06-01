import { bootstrapApplication } from '@angular/platform-browser';
import { AppComponent } from './app/app.component';
import { provideRouter } from '@angular/router';
import { UsingInjectableComponent } from './app/using-injectable/using-injectable.component';
import { UsingComponentComponent } from './app/using-component/using-component.component';
import { DetailViewComponent } from './app/using-component/detail-view/detail-view.component';

bootstrapApplication(AppComponent, {
  providers: [
    provideRouter([
      {path: 'inject', component: UsingInjectableComponent},
      {path: 'component', component: UsingComponentComponent},
      {path: 'component/:id', component: DetailViewComponent},
      {path: '', redirectTo: 'inject', pathMatch: 'full'}
    ])
  ]
})
  .catch((err) => console.error(err));
