import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { LandingComponent } from "./landing.component";

const routes: Routes = [{
    path: '', component: LandingComponent, children:[
        {
            path: 'customers', loadChildren: () => import('../../pages/customer/customer.module').then(m => m.CustomerModule)
        }
    ]
}]

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class LandingRoutingModule {}