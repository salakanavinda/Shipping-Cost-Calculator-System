import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import{ FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { SelectDropDownModule } from 'ngx-select-dropdown'

//Entity
import { Method } from './entity/method';
import { Item } from './entity/item';
import { Weight } from './entity/weight';
import { Country } from './entity/country';
import { Service } from './entity/service';
import { Rate } from './entity/rate';
import { ServiceRate } from './entity/serviceRate';

//COMPONENTS
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { NavigationComponent } from './components/navigation/navigation.component';
import { InvoiceComponent } from './components/invoice/invoice.component';
import { FooterComponent } from './components/footer/footer.component';
import { MainViewComponent } from './components/main-view/main-view.component';
import { Global } from './entity/global';
import { DetailsComponent } from './components/details/details.component';




@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    NavigationComponent,
    InvoiceComponent,
    FooterComponent,
    MainViewComponent,
    DetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    SelectDropDownModule
  ],
  providers: [Method, Item, Weight, Country, Service, Rate, ServiceRate,Global],
  bootstrap: [AppComponent]
})
export class AppModule { }
