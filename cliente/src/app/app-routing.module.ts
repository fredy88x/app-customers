import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [{path:'', redirectTo:'alianza', pathMatch:'full'},{
  path: 'alianza', loadChildren:()=>import('../app/components/landing/landing.module').then(m=>m.LandingModule)
}];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash:true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
