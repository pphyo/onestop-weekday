import { bootstrapApplication } from '@angular/platform-browser';
import { AppComponent } from './app/app.component';
import { ROUTES, provideRouter } from '@angular/router';
import { TemplateComponent } from './app/template/template.component';
import { ReactiveComponent } from './app/reactive/reactive.component';
import { DynamicComponent } from './app/dynamic/dynamic.component';

ROUTES

bootstrapApplication(AppComponent, {
  providers: [
    provideRouter([
      {path: 'template', component: TemplateComponent},
      {path: 'reactive', component: ReactiveComponent},
      {path: 'dynamic', component: DynamicComponent},
      {path: '', pathMatch: 'full', redirectTo: '/template'}
    ])
  ]
})
  .catch((err) => console.error(err));
