import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { ViewallComponent } from './viewall/viewall.component';
import { ProductDetailsComponent } from './product-details/product-details.component';
import { CartComponent } from './cart/cart.component';
import { ShowAdsComponent } from './show-ads/show-ads.component';
import { AdsdetailsComponent } from './adsdetails/adsdetails.component';
import { PostadComponent } from './postad/postad.component';
import { DataService } from './data.service';
import { HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './login/login.component'; // Import HttpClientModule
import { FormsModule } from '@angular/forms';
import { TestComponent } from './test/test.component';
import { UseradsComponent } from './userads/userads.component'; // Import FormsModule

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    HeaderComponent,
    FooterComponent,
    ViewallComponent,
    ProductDetailsComponent,
    CartComponent,
    ShowAdsComponent,
    AdsdetailsComponent,
    PostadComponent,
    LoginComponent,
    TestComponent,
    UseradsComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
  ],
  providers: [DataService],
  bootstrap: [AppComponent]
})
export class AppModule { }
