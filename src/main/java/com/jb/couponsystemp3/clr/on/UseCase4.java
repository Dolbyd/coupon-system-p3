package com.jb.couponsystemp3.clr.on;


import com.jb.couponsystemp3.beans.Category;
import com.jb.couponsystemp3.beans.Company;
import com.jb.couponsystemp3.beans.Coupon;
import com.jb.couponsystemp3.beans.Customer;
import com.jb.couponsystemp3.service.AdminService;
import com.jb.couponsystemp3.service.CompanyService;
import com.jb.couponsystemp3.service.CustomerService;
import com.jb.couponsystemp3.utils.Art;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;

@Component
@Order(4)
@RequiredArgsConstructor
public class UseCase4 implements CommandLineRunner {

    private final AdminService adminService;
    private final CompanyService companyService;
    private final CustomerService customerService;

    @Override
    public void run(String... args) throws Exception {


        Coupon cou1 = Coupon.builder()
                .category(Category.FOOTBALL)
                .title("Football clothes")
                .description("Real-Madrid-FC shirt")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusMonths(1)))
                .amount(50)
                .price(379)
                .image("https://www.sportsdirect.com/images/products/37735801_l.jpg")
                .build();

        Coupon cou19 = Coupon.builder()
                .category(Category.FOOTBALL)
                .title("Football hat")
                .description("Real-Madrid-FC hat")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusMonths(1)))
                .amount(50)
                .price(129)
                .image("https://www.tradeinn.com/f/13766/137669497_3/adidas-real-madrid-baseball-cap.jpg")
                .build();

        Company comp1 = Company.builder()
                .name("Real-Madrid-FC")
                .email("Real-Madrid-FC@gmail.com")
                .password("123")
                .build();

        Coupon cou2 = Coupon.builder()
                .category(Category.FOOTBALL)
                .title("Football clothes")
                .description("Barcelona-FC shirt")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusMonths(1)))
                .amount(50)
                .price(415)
                .image("https://m.media-amazon.com/images/I/81jr7MtwNiL._UL1500_.jpg")
                .build();

        Coupon cou20 = Coupon.builder()
                .category(Category.FOOTBALL)
                .title("Football hat")
                .description("Barcelona-FC hat")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusMonths(1)))
                .amount(50)
                .price(135)
                .image("https://m.media-amazon.com/images/I/61DGLmUUv1L._AC_UL1001_.jpg")
                .build();

        Company comp2 = Company.builder()
                .name("Barcelona-FC")
                .email("Barcelona-FC@gmail.com")
                .password("123")
                .build();

        Coupon cou3 = Coupon.builder()
                .category(Category.FOOTBALL)
                .title("Football clothes")
                .description("Liverpool-FC shirt")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusMonths(1)))
                .amount(50)
                .price(389)
                .image("https://www.sportsdirect.com/images/products/37700408_l_a11.jpg")
                .build();

        Coupon cou21 = Coupon.builder()
                .category(Category.FOOTBALL)
                .title("Football hat")
                .description("Liverpool-FC hat")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusMonths(1)))
                .amount(50)
                .price(105)
                .image("https://img.hatshopping.co.uk/Liverpool-FC-Strapback-Cap-by-47-Brand.57834_pf3.jpg")
                .build();

        Company comp3 = Company.builder()
                .name("Liverpool-FC")
                .email("Liverpool-FC@gmail.com")
                .password("123")
                .build();

        Coupon cou4 = Coupon.builder()
                .category(Category.FOOTBALL)
                .title("Football clothes")
                .description("Manchester-United-FC shirt")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusMonths(1)))
                .amount(50)
                .price(519)
                .image("https://cdn.idealo.com/folder/Product/200509/5/200509571/s3_produktbild_gross/adidas-manchester-united-shirt-2021.jpg")
                .build();

        Coupon cou22 = Coupon.builder()
                .category(Category.FOOTBALL)
                .title("Football hat")
                .description("Manchester-United-FC hat")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusMonths(1)))
                .amount(50)
                .price(188)
                .image("https://assets.adidas.com/images/w_940,f_auto,q_auto/07d90c6a47b14774a8efade301456516_9366/H62461_01_standard.jpg")
                .build();

        Company comp4 = Company.builder()
                .name("Manchester-United-FC")
                .email("Manchester-United-FC@gmail.com")
                .password("123")
                .build();

        Coupon cou5 = Coupon.builder()
                .category(Category.FOOTBALL)
                .title("Football clothes")
                .description("Juventus-FC shirt")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusMonths(1)))
                .amount(50)
                .price(420)
                .image("https://store.juventus.com/data/store/product/5/51828/product.jpg")
                .build();

        Coupon cou23 = Coupon.builder()
                .category(Category.FOOTBALL)
                .title("Football hat")
                .description("Juventus-FC hat")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusMonths(1)))
                .amount(50)
                .price(99)
                .image("https://www.evangelistasports.com/31282-medium_default/adidas-juventus-fc-baseball-cap-202223-white-black-H59701.jpg")
                .build();

        Company comp5 = Company.builder()
                .name("Juventus-FC")
                .email("Juventus-FC@gmail.com")
                .password("123")
                .build();

        Coupon cou6 = Coupon.builder()
                .category(Category.FOOTBALL)
                .title("Football clothes")
                .description("Milan-FC shirt")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusMonths(1)))
                .amount(50)
                .price(309)
                .image("https://gfx.r-gol.com/media/res/products/262/136262/koszulka-puma-ac-milan-2020-21-domowa-replica_1.png")
                .build();

        Coupon cou24 = Coupon.builder()
                .category(Category.FOOTBALL)
                .title("Football hat")
                .description("Milan-FC hat")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusMonths(1)))
                .amount(50)
                .price(75)
                .image("https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_2000,h_2000/global/022751/09/fnd/GBR/fmt/png")
                .build();

        Company comp6 = Company.builder()
                .name("Milan-FC")
                .email("Milan-FC@gmail.com")
                .password("123")
                .build();

        Coupon cou7 = Coupon.builder()
                .category(Category.BASKETBALL)
                .title("Basketball clothes")
                .description("Golden State Warriors shirt")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusMonths(1)))
                .amount(50)
                .price(415)
                .image("https://images.footballfanatics.com/golden-state-warriors/golden-state-warriors-nike-icon-swingman-jersey-stephen-curry-mens_ss4_p-12020130+pv-1+u-97u8ef14qporv8j3yhs5+v-3e52157faee64acebb50e86778a57796.jpg?_hv=1&w=600")
                .build();

        Company comp7 = Company.builder()
                .name("Golden State Warriors")
                .email("GoldenStateWarriors@gmail.com")
                .password("123")
                .build();

        Coupon cou8 = Coupon.builder()
                .category(Category.BASKETBALL)
                .title("Basketball clothes")
                .description("Boston Celtics shirt")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusMonths(1)))
                .amount(50)
                .price(395)
                .image("https://static.nike.com/a/images/t_PDP_1280_v1/f_auto,q_auto:eco/4abdb542-e432-482d-8e0e-5793bf2341e4/boston-celtics-city-edition-dri-fit-nba-swingman-jersey-XqRchv.png")
                .build();

        Company comp8 = Company.builder()
                .name("Boston Celtics")
                .email("BostonCeltics@gmail.com")
                .password("123")
                .build();

        Coupon cou9 = Coupon.builder()
                .category(Category.BASKETBALL)
                .title("Basketball clothes")
                .description("Los Angeles Lakers shirt")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusMonths(1)))
                .amount(50)
                .price(385)
                .image("https://m.media-amazon.com/images/I/615YZmn7CNL._AC_UX385_.jpg")
                .build();

        Company comp9 = Company.builder()
                .name("Los Angeles Lakers")
                .email("LosAngelesLakers@gmail.com")
                .password("123")
                .build();

        Coupon cou10 = Coupon.builder()
                .category(Category.BASKETBALL)
                .title("Basketball clothes")
                .description("Chicago Bulls shirt")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusMonths(1)))
                .amount(50)
                .price(809)
                .image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQetvGxLSmkI4rmDR_QHLSpoqekLtojRc7EFhrsT2MN9uRStcsmcWP1xoUcVYv2TvvQWJhoKSQr&usqp=CAc")
                .build();

        Company comp10 = Company.builder()
                .name("Chicago Bulls")
                .email("ChicagoBulls@gmail.com")
                .password("123")
                .build();

        Coupon cou11 = Coupon.builder()
                .category(Category.BASKETBALL)
                .title("Basketball clothes")
                .description("Miami Heat shirt")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusMonths(1)))
                .amount(50)
                .price(735)
                .image("https://cdn.shopify.com/s/files/1/1368/0393/products/jimmyauthentic_large.jpg?v=1654716062")
                .build();

        Company comp11 = Company.builder()
                .name("Miami Heat")
                .email("MiamiHeat@gmail.com")
                .password("123")
                .build();

        Coupon cou12 = Coupon.builder()
                .category(Category.BASKETBALL)
                .title("Basketball clothes")
                .description("Brooklyn Nets shirt")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusMonths(1)))
                .amount(50)
                .price(666)
                .image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQHhCy8ew6PTayx_RtvSm9JsxnyMeICBOKEDoZ_W7SxUt0X9jgQlFdGQ7YJPFpIYvs530s28Q0&usqp=CAc")
                .build();

        Company comp12 = Company.builder()
                .name("Brooklyn Nets")
                .email("BrooklynNets@gmail.com")
                .password("123")
                .build();

        Coupon cou13 = Coupon.builder()
                .category(Category.BASEBALL)
                .title("Baseball clothes")
                .description("New York Yankees shirt")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusMonths(1)))
                .amount(50)
                .price(339)
                .image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSPIPShsevhaZi1Ozj1m0uR4Aj6ggfrDIknz4dpBoxleIrTlHU&usqp=CAc")
                .build();

        Company comp13 = Company.builder()
                .name("New York Yankees")
                .email("NewYorkYankees@gmail.com")
                .password("123")
                .build();

        Coupon cou14 = Coupon.builder()
                .category(Category.BASEBALL)
                .title("Baseball clothes")
                .description("Boston Red Sox shirt")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusMonths(1)))
                .amount(50)
                .price(504)
                .image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTqbERJ3LGK6r3S_cYk-6qiDi20E5FBdkyZ7hVHx8Thwd2Nvmcx&usqp=CAc")
                .build();

        Company comp14 = Company.builder()
                .name("Boston Red Sox")
                .email("BostonRedSox@gmail.com")
                .password("123")
                .build();

        Coupon cou15 = Coupon.builder()
                .category(Category.BASEBALL)
                .title("Baseball clothes")
                .description("Los Angeles Dodgers shirt")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusMonths(1)))
                .amount(50)
                .price(189)
                .image("https://static.nike.com/a/images/t_PDP_1280_v1/f_auto,q_auto:eco/d9ee6cd8-e8a5-4f87-b95b-4f577b9abbd3/los-angeles-dodgers-mookie-betts-mens-replica-baseball-jersey-1SkB2r.jpg")
                .build();

        Company comp15 = Company.builder()
                .name("Los Angeles Dodgers")
                .email("LosAngelesDodgers@gmail.com")
                .password("123")
                .build();

        Coupon cou16 = Coupon.builder()
                .category(Category.BASEBALL)
                .title("Baseball clothes")
                .description("New York Mets shirt")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusMonths(1)))
                .amount(50)
                .price(321)
                .image("https://www.tradeinn.com/f/13875/138758425/nike-new-york-mets-replica-alternate-home-22-23.jpg?_gl=1*1a6pu0e*_up*MQ..&gclid=CjwKCAjw0dKXBhBPEiwA2bmObS_9igyHL8YvDvpQ10ZQGqtiDdGzhBr1VG75SRdYTBFoG2KjEOG1MBoC60YQAvD_BwE&gclsrc=aw.ds")
                .build();

        Company comp16 = Company.builder()
                .name("New York Mets")
                .email("NewYorkMets@gmail.com")
                .password("123")
                .build();

        Coupon cou17 = Coupon.builder()
                .category(Category.BASEBALL)
                .title("Baseball clothes")
                .description("San Francisco Giants shirt")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusMonths(1)))
                .amount(50)
                .price(388)
                .image("https://cdn2.basket4ballers.com/117331-large_default/baseball-shirt-mlb-san-francisco-giants-nike-official-cooperstown-edition-c267-wg83-g83-uct.jpg")
                .build();

        Company comp17 = Company.builder()
                .name("San Francisco Giants")
                .email("SanFranciscoGiants@gmail.com")
                .password("123")
                .build();

        Coupon cou18 = Coupon.builder()
                .category(Category.BASEBALL)
                .title("Baseball clothes")
                .description("Baltimore Orioles shirt")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusMonths(1)))
                .amount(50)
                .price(755)
                .image("https://i5.walmartimages.com/asr/bdd6da8c-4818-415b-ad4f-8989eb23dbf1.35e7364abb1c773b3453b44c19003642.jpeg?odnHeight=612&odnWidth=612&odnBg=FFFFFF\\")
                .build();

        Company comp18 = Company.builder()
                .name("Baltimore Orioles")
                .email("BaltimoreOrioles@gmail.com")
                .password("123")
                .build();

        Customer cr1 = Customer.builder()
                .firstName("Moshe")
                .lastName("Cohen")
                .email("moshe@gmail.com")
                .password("123")
                .build();

        Customer cr2 = Customer.builder()
                .firstName("Hila")
                .lastName("Levi")
                .email("Hila@gmail.com")
                .password("123")
                .build();

        Customer cr3 = Customer.builder()
                .firstName("Yatzek")
                .lastName("Menashe")
                .email("Yatzek@gmail.com")
                .password("123")
                .build();

        Customer cr4 = Customer.builder()
                .firstName("Sagi")
                .lastName("dotan")
                .email("Sagi@gmail.com")
                .password("123")
                .build();

        Customer cr5 = Customer.builder()
                .firstName("gefen")
                .lastName("geva")
                .email("gefen@gmail.com")
                .password("123")
                .build();



        adminService.addCompany(comp1);
        adminService.addCompany(comp2);
        adminService.addCompany(comp3);
        adminService.addCompany(comp4);
        adminService.addCompany(comp5);
        adminService.addCompany(comp6);
        adminService.addCompany(comp7);
        adminService.addCompany(comp8);
        adminService.addCompany(comp9);
        adminService.addCompany(comp10);
        adminService.addCompany(comp11);
        adminService.addCompany(comp12);
        adminService.addCompany(comp13);
        adminService.addCompany(comp14);
        adminService.addCompany(comp15);
        adminService.addCompany(comp16);
        adminService.addCompany(comp17);
        adminService.addCompany(comp18);

        System.out.println("\n-*-*-*-*-*-*-*-*-*-*-*-*-*-  add customers  -*-*-*-*-*-*-*-*-*-*-*-*-*-");
        adminService.addCustomer(cr1);
        adminService.addCustomer(cr2);
        adminService.addCustomer(cr3);
        adminService.addCustomer(cr4);
        adminService.addCustomer(cr5);


        System.out.println("\n-*-*-*-*-*-*-*-*-*-*-*-*-*-  add company coupon  -*-*-*-*-*-*-*-*-*-*-*-*-*-");

        companyService.setCompany(companyService.getCompanyByEmail(comp1.getEmail()));
        companyService.addCoupon(cou1);
        companyService.addCoupon(cou19);
        companyService.setCompany(companyService.getCompanyByEmail(comp2.getEmail()));
        companyService.addCoupon(cou2);
        companyService.addCoupon(cou20);
        companyService.setCompany(companyService.getCompanyByEmail(comp3.getEmail()));
        companyService.addCoupon(cou3);
        companyService.addCoupon(cou21);
        companyService.setCompany(companyService.getCompanyByEmail(comp4.getEmail()));
        companyService.addCoupon(cou4);
        companyService.addCoupon(cou22);
        companyService.setCompany(companyService.getCompanyByEmail(comp5.getEmail()));
        companyService.addCoupon(cou5);
        companyService.addCoupon(cou23);
        companyService.setCompany(companyService.getCompanyByEmail(comp6.getEmail()));
        companyService.addCoupon(cou6);
        companyService.addCoupon(cou24);
        companyService.setCompany(companyService.getCompanyByEmail(comp7.getEmail()));
        companyService.addCoupon(cou7);
        companyService.setCompany(companyService.getCompanyByEmail(comp8.getEmail()));
        companyService.addCoupon(cou8);
        companyService.setCompany(companyService.getCompanyByEmail(comp9.getEmail()));
        companyService.addCoupon(cou9);
        companyService.setCompany(companyService.getCompanyByEmail(comp10.getEmail()));
        companyService.addCoupon(cou10);
        companyService.setCompany(companyService.getCompanyByEmail(comp11.getEmail()));
        companyService.addCoupon(cou11);
        companyService.setCompany(companyService.getCompanyByEmail(comp12.getEmail()));
        companyService.addCoupon(cou12);
        companyService.setCompany(companyService.getCompanyByEmail(comp13.getEmail()));
        companyService.addCoupon(cou13);
        companyService.setCompany(companyService.getCompanyByEmail(comp14.getEmail()));
        companyService.addCoupon(cou14);
        companyService.setCompany(companyService.getCompanyByEmail(comp15.getEmail()));
        companyService.addCoupon(cou15);
        companyService.setCompany(companyService.getCompanyByEmail(comp16.getEmail()));
        companyService.addCoupon(cou16);
        companyService.setCompany(companyService.getCompanyByEmail(comp17.getEmail()));
        companyService.addCoupon(cou17);
        companyService.setCompany(companyService.getCompanyByEmail(comp18.getEmail()));
        companyService.addCoupon(cou18);

        customerService.setCustomer(customerService.getCustomerByEmail(cr1.getEmail()));
        customerService.purchaseCoupon(cou1);
        customerService.purchaseCoupon(cou22);
        customerService.purchaseCoupon(cou11);
        customerService.purchaseCoupon(cou9);
        customerService.purchaseCoupon(cou3);
        customerService.purchaseCoupon(cou7);
        customerService.setCustomer(customerService.getCustomerByEmail(cr2.getEmail()));
        customerService.purchaseCoupon(cou2);
        customerService.purchaseCoupon(cou19);
        customerService.purchaseCoupon(cou3);
        customerService.purchaseCoupon(cou20);
        customerService.setCustomer(customerService.getCustomerByEmail(cr3.getEmail()));
        customerService.purchaseCoupon(cou13);
        customerService.purchaseCoupon(cou14);
        customerService.setCustomer(customerService.getCustomerByEmail(cr4.getEmail()));
        customerService.purchaseCoupon(cou1);
        customerService.purchaseCoupon(cou2);
        customerService.purchaseCoupon(cou3);
        customerService.purchaseCoupon(cou4);
        customerService.purchaseCoupon(cou5);
        customerService.purchaseCoupon(cou6);
        customerService.setCustomer(customerService.getCustomerByEmail(cr5.getEmail()));
        customerService.purchaseCoupon(cou7);
        customerService.purchaseCoupon(cou8);
        customerService.purchaseCoupon(cou9);
        customerService.purchaseCoupon(cou10);
        customerService.purchaseCoupon(cou11);
        customerService.purchaseCoupon(cou12);
        customerService.purchaseCoupon(cou13);

    }


}
