package com.fdmgroup.flexdronepodq42022.Data;

import com.fdmgroup.flexdronepodq42022.Controller.EnquiryController;
import com.fdmgroup.flexdronepodq42022.Controller.OrderController;
import com.fdmgroup.flexdronepodq42022.DTO.RegisterDto;
import com.fdmgroup.flexdronepodq42022.Model.Product;
import com.fdmgroup.flexdronepodq42022.Model.Role;
import com.fdmgroup.flexdronepodq42022.Repository.*;
import com.fdmgroup.flexdronepodq42022.Service.AuthService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private final RoleRepository roleRepository;
    private final ProductRepository productRepository;
    private final SupplierRepository supplierRepository;
    private final ProductSupplierRepository productSupplierRepository;
    private final EnquiryController enquiryController;
    private final OrderController orderController;
    private final AuthService authService;
    private final UserRepository userRepository;
    PasswordEncoder passwordEncoder;

    @Autowired
    public DataLoader(RoleRepository roleRepository, ProductRepository productRepository,
                      SupplierRepository supplierRepository,
                      ProductSupplierRepository productSupplierRepository, EnquiryController enquiryController,
                      PasswordEncoder passwordEncoder, OrderController orderController, AuthService authService,
                      UserRepository userRepository) {

        this.roleRepository = roleRepository;
        this.productRepository = productRepository;
        this.supplierRepository = supplierRepository;
        this.productSupplierRepository = productSupplierRepository;
        this.enquiryController = enquiryController;
        this.passwordEncoder = passwordEncoder;
        this.orderController = orderController;
        this.authService = authService;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        // Role Dummy Data
//        Role roleAdmin = new Role("ROLE_ADMIN");
//        Role roleUser = new Role("ROLE_USER");
//        Role savedAdminRole = roleRepository.save(roleAdmin);
//        Role savedUserRole = roleRepository.save(roleUser);
//
//        // Admin Dummy Data
//        RegisterDto adminUser = new RegisterDto();
//        adminUser.setName("Sarabjeet Singh");
//        adminUser.setUsername("admin");
//        adminUser.setEmail("admin@email.com");
//        adminUser.setPassword("L^C$ew%CVZeKX4");
//        authService.registerAdmin(adminUser);
//
//        // User Dummy Data
//        RegisterDto normalUser = new RegisterDto();
//        normalUser.setName("John Doe");
//        normalUser.setUsername("johnsmith");
//        normalUser.setEmail("noahmiller238@gmail.com");
//        normalUser.setPassword("L^C$ew%CVZeKX4");
//        authService.register(normalUser);
//
//        productRepository.save(new Product(0, "Act-Cam-DJI-P-B-A10-MI-0001", "Black, 250g, 4K motorized action camera.", 60900L, "Camera", "Action Camera DJI", 12, 10, 12, true, "", "Reorder", "https://cdn.shopify.com/s/files/1/0024/9803/5810/products/607322-Product-0-I-637986688640559220_0df3226f-62c8-481d-939f-d19590909ea7_934x.jpg?v=1663036559", 1, 0));
//        productRepository.save(new Product(1, "Har-Bat-Inn-P-R-B23-SM-0003", "Red, 4kg, 44Wh capacity", 22900L, "Battery", "Harpo Intelligent Flight Battery", 19, 11, 12, true, "", "", "https://cdn.shopify.com/s/files/1/0594/7945/7990/products/AerooIntelligentFlightBattery_1024x1024@2x.jpg?v=1632188925", 1, 0));
//        productRepository.save(new Product(2, "DXT-Win-Gua-P-W-D12-ME-0004", "Yellow, 575mm flying wing", 10300L, "Wings", "DXT Flight Wings", 52, 38, 12, true, "", "", "https://m.media-amazon.com/images/I/71MBrlR3CKL._AC_SX679_.jpg", 1, 0));
//        productRepository.save(new Product(3, "Awe-Con-DJI-D-B-A10-MI-0006", "20X20 Flight Controller V2.1", 7000L, "Controller", "Awesome Flight Controller DJI", 30, 12, 15, true, "", "", "https://www.d1store.com.au/images/products/DJI-RC-02.jpg", 1, 0));
//        productRepository.save(new Product(4, "Fan-Rad-Syn-P-B-A07-VS-0007", "Lite long range module", 8500L, "Radio", "Fan Long Range Communication Radio", 30, 20, 13, true, "", "", "https://www.radioparts.com.au/images/ProductImages/08607292.jpg", 1, 0));
//        productRepository.save(new Product(5, "Ele-Cha-Inn-M-W-B23-SM-0008", "Yellow, Nano battery 200W 8A", 3200L, "Charger", "Element Nano Battery Charger", 0, 5, 15, true, "Out of stock", "", "https://www.auselectronicsdirect.com.au/assets/full/PS1178.jpg?20220321231425", 1, 0));
//        productRepository.save(new Product(6, "Com-Tra-Gua-D-B-D12-ME-0009", "Black, 30 x 23 x 5.5mm, 7g, 6V - 26V (2S - 6S)", 9990L, "Transmitter", "Coms Pro Transmitter", 19, 18, 14, true, "", "", "https://m.media-amazon.com/images/I/51rAjhJFZRL._AC_UF894,1000_QL80_.jpg", 1, 0));
//        productRepository.save(new Product(7, "Pow-Mot-Ple-P-W-D12-MI-0001", "Red, 30 x 23 x 5.5mm, 6g, 6V - 26V (2S - 6S)", 9900L, "Motor", "Power Technology CF-Arm Frame", 39, 20, 12, true, "", "", "https://ae01.alicdn.com/kf/He2d0abfda0ae419a9eb09ba9578370a9a/Diatone-RcMA-F1-Traversing-Machine-Carbon-Fiber-Frame-1-6-Inch-3S-Power-With-Protection-Ring.jpg_Q90.jpg_.webp", 1, 0));
//        productRepository.save(new Product(8, "Epi-RTF-DJI-D-B-A13-LA-0001", "8GB of Storage Space, 3-Axis Gimbal with Dual Cameras, Up to 46 Minutes of Flight Time, Up to 9.3-Mile Transmission Range, RC-N1 OcuSync 2.0 Remote Included ", 89600L, "RTF Drone", "Epic Mavic 3", 14, 13, 10, false, "", "", "https://www.dpreview.com/files/p/articles/0047640267/1974DC4F-DA77-4A39-AEA4-1991FF1063BD.jpeg", 1, 0));
//        productRepository.save(new Product(9, "UAV-Cam-Lam-P-B-B23-MI-0002", "UAV Low-Light Navigation Camera with maximized low-light sensitivity", 53000L, "Camera", "UAV photogrammetry camera", 17, 23, 10, true, "", "", "https://www.d1store.com.au/images/products/D1store_Zenmuse_h20t_product_image.jpg", 1, 0));
//        productRepository.save(new Product(10, "Eac-Prop-Tal-M-B-D12-VS-0001", "Eachine 6/7mm 4-Blade propellers  0.8mm haft for brushed motors.", 2500L, "Propeller", "Eachine E58 Drone Propeller Guard", 16, 33, 12, true, "", "", "https://assets.kogan.com/images/dronesxpress/DRX-11395349413924/1-43d5513bb9-eachine-e58-drone-propeller-guard-propellers-drones-xpress_a2fbd67d-3b47-4536-8082-502967f69538.jpg?auto=webp&canvas=753%2C502&fit=bounds&height=502&quality=75&width=753", 1, 0));
//        productRepository.save(new Product(0, "Dro-Bat-Lui-P-R-A10-SM-0001", "Rechargeable Lithium Battery7.4V 350mAh TR003 Dron", 20000L, "Battery", "Drone Diy Spare Parts Lithium Battery", 0, 2, 14, true, "Out of stock", "Low Stock", "https://cdn.shopify.com/s/files/1/0153/9135/9024/products/O-100C-1550-4S1P-XT60-3_1800x1800.jpg?v=1657715325", 1, 0));
//        productRepository.save(new Product(0, "Lon-Win-Fer-P-R-A07-ME-0001", "White - Quick Release Foldable Wings - Flight Tested - Essential DJI Mavic Pro Accessory", 11500L, "Wings", "Long Distance Fixed Wing", 12, 34, 10, true, "", "", "https://imgaz2.staticbg.com/thumb/large/oaupload/banggood/images/48/9C/ab1f2777-d16f-4491-a494-5a40cb7fe860.png.webp", 1, 0));
//        productRepository.save(new Product(0, "S55-Con-Jiv-D-W-B23-MI-0001", "2.4GHz AFHDS RC Transmitter w/ FS-iA6B Receiver", 12200L, "Controller", "S550 DIY Drone Kit Unassembly PNF 6-Axle Helicopter PIX4 Flight Control ", 25, 23, 12, true, "", "", "https://cdn.shopify.com/s/files/1/0428/1981/3533/products/41fjVuboD1L_900x.jpg?v=1658479879", 1, 0));
//        productRepository.save(new Product(0, "FPV-Char-Sun-M-R-A19-SM-0007", "12V 1A Power Supply Adapter, Plug 5.5mm x 2.1mm", 3000L, "Charger", "FPV AC Power ", 31, 21, 15, true, "", "", "https://cdn.shopify.com/s/files/1/1477/4314/products/9ac2a28ff6caef064b9cc8bba4267902fc85d7d8.png?v=1614732240", 1, 0));
//        productRepository.save(new Product(0, "Eac-Mot-Lea-P-R-D22-MI-0003", " T-Motor F1507 1507 2700KV 3-6S. (4PCs)", 8900L, "Motor", "Eachine 220W motor", 20, 19, 15, true, "", "", "https://ae01.alicdn.com/kf/Hfb80d0c98f8d4ee3a3aeae1decc869a5P.jpg", 1, 0));
//        productRepository.save(new Product(0, "CoD-Win-Jet-D-W-C23-MI-0003", "730mm Wingspan Dual Motor EPP FPV Racer RC Airplane Fixed Wing KIT/PNP", 11500L, "Wings", "CoDrone Pro Wings", 32, 20, 15, true, "", "", "https://ae01.alicdn.com/kf/Sf7d1376549154d2aa4280b8f05a58eb2N/K911-AE8-PRO-MAX-GPS-Rc-Drone-Accessories-Propellers-Blades-K911max-Quadcopter-Props-Spare-Parts.jpg_Q90.jpg_.webp", 1, 0));
//        productRepository.save(new Product(0, "Int-Con-Dro-P-W-A11-VS-0002", "Program Detailed Flight Plans in 2D/3D, Uses Intel's Mission Control Software", 11500L, "Controller", "Intel Cockpit Remote Controller for Falcon 8+ Octacopter Radio Controllers ...", 18, 15, 12, true, "", "", "https://www.modelflight.com.au/media/catalog/product/s/p/spmrftx1_b0.jpg?quality=80&bg-color=255,255,255&fit=bounds&height=560&width=700&canvas=700:560", 1, 0));
//        productRepository.save(new Product(0, "GPS-Rad-Fly-M-B-B20-SM-0002", "Certa 6V/12V 9 Stage Smart Battery Charger 2/4/6.5 Amp", 9000L, "Radio", "GPS 2.4g Selfie RC Radio", 20, 25, 12, true, "", "", "https://www.modelflight.com.au/media/catalog/product/S/P/SPMR14000_A5_WZK7S072.jpg.jpg?quality=80&bg-color=255,255,255&fit=bounds&height=560&width=700&canvas=700:560", 1, 0));
//        productRepository.save(new Product(0, "Cer-Char-Spi-D-R-C23-ME-0002", "1.5m, 20W, Battery Voltage 6V/12V, IP65, Weight 400g, 19 x 5 x4 cm", 3000L, "Charger", "Certif 6V/12V Smart Battery", 20, 18, 15, true, "", "", "https://assets.kogan.com/files/external/2022-Oct-Hero-Update/CT5SMTBTCHA_new_hero.jpg?auto=webp&bg-color=fff&canvas=753%2C502&fit=bounds&height=502&quality=75&width=753", 1, 0));
//        productRepository.save(new Product(0, "5GD-Fra-Rop-P-W-B2-MI-0005", "Built In Camera 4K UHD w/ 3X Batteries Pro Kit", 9090L, "Frame", "5GDrone", 20, 32, 15, true, "", "", "https://assets.kogan.com/images/dronesxpress/DRX-32607096012836/1-470ccac488-f3-drone-drones-drones-xpress-gps-5g-4k-3b_d621a69e-ed65-43fc-9520-c9bb905347f0.jpg?auto=webp&bg-color=fff&canvas=753%2C502&fit=bounds&height=502&quality=75&width=753", 1, 0));
//        productRepository.save(new Product(0, "Lev-RTF-Fig-D-W-C14-LA-0004", "4k Camera, S Flight Mode, Super-Wide 150 FOV, Emergency Brake and Hover", 90000L, "RTF Drone", "Leviation FPV 4K Drone Combo", 18, 15, 10, false, "", "", "https://cdn.shopify.com/s/files/1/0024/9803/5810/products/511193-Product-0-I-637503754147543757_75f1131b-7001-4e1a-bb76-cff49545ed8a.jpg?v=1614740766", 1, 0));
//        productRepository.save(new Product(0, "Mag-Cam-Lam-P-B-A09-MI-0005", "Black, 250g, 4K motorized action camera.", 60900L, "Camera", "Magnify 4k Camera ", 12, 10, 12, true, "", "Reorder", "https://www.netnest.com.au/Content/images/SEFLCF6308000.webp", 1, 0));
//        productRepository.save(new Product(0, "Swe-Pro-Tal-P-W-B12-VS-0006", "Green, lightweight, plastic propellers ", 1900L, "Propeller", "SweepPro Propeller", 32, 8, 15, true, "", "", "https://cdn.shopify.com/s/files/1/2472/2530/products/1242_carbon_propellers_5000x.jpg?v=1593496474", 1, 0));
//        productRepository.save(new Product(0, "Ovo-Bat-Lui-D-R-B05-SM-0007", "Red, 4kg, 44Wh capacity", 22900L, "Battery", "Ovol Battery", 19, 11, 12, true, "", "", "https://m.media-amazon.com/images/I/51IcmpVEswL._AC_UF894,1000_QL80_.jpg", 1, 0));
//        productRepository.save(new Product(0, "Eli-Win-Fer-M-W-C01-MI-0008", "White - Quick Release Foldable Wings - Flight Tested - Essential DJI Mavic Pro Accessory", 10300L, "Wings", "EliteDrone wings", 52, 38, 12, true, "", "", "https://crkphotoimaging.com.au/product_image/ts1616532956/rc_600x600/DJIMAVIC2PT13/dji-mavic-2-pt13-low-noise-propellers-pair---cw---ccw---yc-sj-gg000035-03-34-03.jpg", 1, 0));
//        productRepository.save(new Product(0, "Lan-Con-Jiv-P-B-C13-VS-0009", "20X20 Flight Controller V2.1", 7800L, "Controller", "LangoLingo Command Controller", 30, 12, 15, true, "", "", "https://www.ozled.com.au/assets/full/22GO601.png?20220719094440", 1, 0));
//        productRepository.save(new Product(0, "Ava-Rad-Lya-P-B-D17-SM-0010", "2.4GHz AFHDS RC Transmitter w/ FS-iA6B Receiver", 8500L, "Radio", "Avantree TR927 Radio", 30, 20, 13, true, "", "", "https://m.media-amazon.com/images/I/61tDPvWSRdL._AC_SX679_.jpg", 1, 0));
//        productRepository.save(new Product(0, "Zap-Cha-Sun-D-W-A04-SM-0011", "Program Detailed Flight Plans in 2D/3D, Uses Intel's Mission Control Software", 3200L, "Charger", "Zaperuni 10 Amps Charger", 0, 5, 15, true, "Out of stock", "", "https://www.auselectronicsdirect.com.au/assets/full/PS1083.jpg?20210309031357", 1, 0));
//        productRepository.save(new Product(0, "Yun-Tra-Ado-D-B-A07-ME-0012", "1.5m, 20W, Battery Voltage 6V/12V, IP65, Weight 400g, 19 x 5 x4 cm", 9990L, "Transmitter", "Yundt Pro Transmitter", 19, 18, 14, true, "", "", "https://d33i9xhtscn2ox.cloudfront.net/images/MED600_JW-P-881506.jpg", 1, 0));
//        productRepository.save(new Product(0, "Eag-Mot-Lea-M-W-C09-MI-0014", "Built In Camera 4K UHD w/ 3X Batteries Pro Kit", 9900L, "Motor", "EagleMight SA1234 Motor", 39, 20, 12, true, "", "", "https://au.element14.com/productimages/standard/en_US/51AC6761-40.jpg", 1, 0));
//        productRepository.save(new Product(0, "Twi-Cam-Jet-P-B-D20-MI-0016", "Night vision Camera with maximized low-light sensitivity", 60900L, "Camera", "Twilight Night Vision Camera", 17, 23, 10, true, "", "", "https://imgaz.staticbg.com/thumb/large/oaupload/banggood/images/89/81/a54be28f-4a13-4247-9b77-4f64c33f94d8.jpg.webp", 1, 0));
//        productRepository.save(new Product(0, "10P-Pro-Dro-P-B-D14-VS-0017", "Eachine 6/7mm 4-Blade propellers  0.8mm haft for brushed motors.", 1900L, "Propeller", "10Pcs Quick Release Propellers", 16, 33, 12, true, "", "", "https://cdn.shopify.com/s/files/1/0016/7215/1101/products/product-image-800313356_1080x.jpg?v=1571708533", 1, 0));
//        productRepository.save(new Product(0, "5GC-Bat-Fly-D-R-C09-SM-0018", "Red, 4kg, 40Wh capacity", 18000L, "Battery", "5G Compact Pro Kit Battery", 0, 2, 14, true, "Out of stock", "Low Stock", "https://www.auselectronicsdirect.com.au/assets/full/TR9037.jpg?20220209115255", 1, 0));
//        productRepository.save(new Product(0, "Ext-Win-Spi-M-R-C08-ME-0019", "Red - Quick Release Foldable Wings - Flight Tested - Essential DJI Mavic Pro Accessory", 10300L, "Wings", "Extreme Power Wings", 12, 34, 10, true, "", "", "https://ae01.alicdn.com/kf/S537c9091650b48a48d2a276360e770e1A/4DRC-V2-Mini-Folding-Drone-Quadcopter-Main-Blade-Propeller-Wing-Spare-Part-RC-Helicopter-Replacement-Rotor.jpg_Q90.jpg_.webp", 1, 0));
//        productRepository.save(new Product(0, "Rog-Con-Rop-P-B-D18-MI-0020", "Program Detailed Flight Plans in 2D/3D, Uses Intel's Mission Control Software", 12000L, "Controller", "RogerThat Remote Controller", 25, 23, 12, true, "", "", "https://m.media-amazon.com/images/I/61B6a3qp5TL._AC_SL1000_.jpg", 1, 0));
//        productRepository.save(new Product(0, "Port-Rad-Fig-P-R-D19-SM-0021", "2.4GHz AFHDS RC Transmitter w/ FS-iA6B Receiver", 6000L, "Radio", "Portable High Freq Radio", 23, 15, 12, true, "", "", "https://cdn.shopify.com/s/files/1/1477/4314/products/A7301768.jpg?v=1624629588", 1, 0));
//        productRepository.save(new Product(0, "Bzz-Cha-Gua-D-W-D08-SM-0022", "1.5m, 20W, Battery Voltage 6V/12V, IP65, Weight 400g, 19 x 5 x4 cm", 3200L, "Charger", "Bzz Bzz Portable Switchable Charger", 31, 21, 15, true, "", "", "https://assets.kogan.com/images/zoestore/ZOE-RM13038/1-5a463fe816-rm13038-1-0868-a3ir.jpg?auto=webp&bg-color=fff&canvas=753%2C502&fit=bounds&height=502&quality=75&width=753", 1, 0));
//        productRepository.save(new Product(0, "Rat-Tra-DJI-D-B-C07-ME-0023", "Black, 30 x 23 x 5.5mm, 7g, 6V - 26V (2S - 6S)", 9990L, "Transmitter", "Rath Reciever Transmitter", 31, 20, 15, true, "", "", "https://fpvfrenzy.com/wp-content/uploads/2016/02/rc-transmitter-300x300.jpg", 1, 0));
//        productRepository.save(new Product(0, "Ray-Mot-Inn-M-B-A20-MI-0025", " T-Motor F1507 1507 2700KV 3-6S. (4PCs)", 9900L, "Motor", "Rayg Roar Motor", 20, 19, 15, true, "", "", "https://cdn.shopify.com/s/files/1/0003/8859/5740/products/Internet_20200406_184848_1_600x.jpg?v=1621132432", 1, 0));
//        productRepository.save(new Product(0, "Vip-RTF-Gua-D-R-B16-LA-0026", "Built In Camera 4K UHD w/ 3X Batteries Pro Kit", 89600L, "RTF Drone", "Viper-V Drone with VR Headset", 20, 19, 10, false, "", "", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRT50i_AzjbsLe9BBBSM86qCjWdYZrpwyRsmg&usqp=CAU", 1, 0));
//        productRepository.save(new Product(0, "Dig-Cam-Ple-P-R-B24-MI-0027", "Black, 230g, 4K motorized action camera.", 60900L, "Camera", "Dig-Digital Action Camera", 32, 20, 15, true, "", "", "https://assets.kogan.com/images/dronesxpress/DRX-31490456289316/1-ea35558b60-gimbal-repair-part-for-dji-mavic-2-pro-drone-camera-gimbals-drones-xpress-mavic-2-zoom_338f5d23-5f0b-4898-9b22-04498df73c09.jpg?auto=webp&bg-color=fff&canvas=753%2C502&fit=bounds&height=502&quality=75&width=753", 1, 0));
//        productRepository.save(new Product(0, "Cem-Pro-Ple-P-W-C14-VS-0028", "Green, lightweight, plastic propellers ", 1900L, "Propeller", "CemKiz Propellers", 18, 15, 12, true, "", "", "https://m.media-amazon.com/images/I/61gUGFNzB1L._SY355_.jpg", 1, 0));
//        productRepository.save(new Product(0, "Max-Bat-DJI-D-R-D01-SM-0029", "Rechargeable Lithium Battery7.4V 350mAh TR003 Dron", 21500L, "Battery", "Max Power Battery", 20, 25, 12, true, "", "", "https://cdn.shopify.com/s/files/1/0261/5125/6149/products/FULLSEND-6S-1550mAh-fpv-lipo-battery-xm2-store-3_1600x.jpg?v=1641268028", 1, 0));
//        productRepository.save(new Product(0, "Vit-Win-Lam-M-R-C01-ME-0030", "730mm Wingspan Dual Motor EPP FPV Racer RC Airplane Fixed Wing KIT/PNP", 10300L, "Wings", "Vital wings", 20, 18, 15, true, "", "", "https://asset1.djicdn.com/uploads/product_photo/image/577/s1000_06.jpg", 1, 0));
//        productRepository.save(new Product(0, "RCR-Con-Fly-P-W-C02-MI-0031", "Program Detailed Flight Plans in 2D/3D, Uses Intel's Mission Control Software", 12000L, "Controller", "RC Remote Controller", 20, 32, 15, true, "", "", "https://img.aeroexpo.online/images_ar/photo-g/171303-13774119.jpg", 1, 0));
//        productRepository.save(new Product(0, "NRG-Cha-Rop-D-B-A09-SM-0033", "1.5m, 20W, Battery Voltage 6V/12V, IP65, Weight 400g, 19 x 5 x4 cm", 3200L, "Charger", "NRG Portable Charger", 20, 19, 10, true, "", "", "https://www.d1store.com.au/images/products/Mavic-Air-2-Car-Charger-1.jpg", 1, 0));
//        productRepository.save(new Product(0, "Pha-Mot-Tal-M-R-A06-MI-0036", "Built In Camera 4K UHD w/ 3X Batteries Pro Kit", 9900L, "Motor", "Phantom 360 Motor", 20, 25, 12, true, "", "", "https://sc04.alicdn.com/kf/H7774bf237906420dae44a0c1609a4d74M.jpg", 1, 0));
//        productRepository.save(new Product(0, "Pro-RTF-Lam-D-B-C08-LA-0037", "4k Camera, S Flight Mode, Super-Wide 150 FOV, Emergency Brake and Hover", 89600L, "RTF Drone", "Professional Drone with 4k Camera", 20, 18, 15, false, "", "", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR41vfb6vUOLMfRo-6WS1zcKU4kv8Wx1G4BHA&usqp=CAU", 1, 0));
//
//        Long longStock = Long.valueOf(111);
//        float retailFloat = 120;
//
//        Product base1 = new Product(longStock, "224454001", "Beginner base model", retailFloat += 1200, "base", "Beginner Base Model", longStock += 100, longStock += 123, longStock, false, "notesTest", "notesTest", "https://stormsend1.djicdn.com/tpc/uploads/carousel/image/7a52cbc2c1fc7b080f62574d33a82e75@origin.jpg", 0, longStock);
//        Product base2 = new Product(longStock, "294454002", "Beginner base model", retailFloat += 1200, "base", "Enterprise Base Model", longStock += 100, longStock += 123, longStock, false, "notesTest", "notesTest", "https://stormsend1.djicdn.com/tpc/uploads/carousel/image/0d6a58a5c7ee8f474e5a34113c5d6d37@origin.jpg", 0, longStock);
//        Product base3 = new Product(longStock, "294454003", "Beginner base model", retailFloat += 1200, "base", "Sports Base Model", longStock += 100, longStock += 123, longStock, false, "notesTest", "notesTest", "https://stormsend1.djicdn.com/tpc/uploads/carousel/image/c32d1f20946a1eea7e76c61eb90fd797@origin.jpg", 0, longStock);
//
//        productRepository.save(base1);
//        productRepository.save(base2);
//        productRepository.save(base3);
//
//        Product battery1 = new Product(longStock, "224454004", "45 Minutes of flying time", retailFloat += 500, "battery", "10000 Mah Battery", longStock += 100, longStock += 123, longStock, false, "notesTest", "notesTest", "https://cdn.shopify.com/s/files/1/0063/3946/1231/products/Untitled2_946x946.jpg?v=1611454888", 0, longStock);
//        Product battery2 = new Product(longStock, "294454005", "60 Minutes of flying time", retailFloat += 700, "battery", "20000 Mah Battery", longStock += 100, longStock += 123, longStock, false, "notesTest", "notesTest", "https://cdn.shopify.com/s/files/1/0063/3946/1231/products/Untitled_7b74f7e6-2282-4471-9227-41f42e0dfafb_1080x1080.jpg?v=1611454888", 0, longStock);
//        Product battery3 = new Product(longStock, "297454006", "90 Minutes of flying time", retailFloat += 900, "battery", "30000 Mah Battery", longStock += 100, longStock += 123, longStock, false, "notesTest", "notesTest", "https://cdn.shopify.com/s/files/1/0063/3946/1231/products/Untitled1_f74c4167-af04-4eca-b612-b55f42662428_1080x1080.jpg?v=1611454888", 0, longStock);
//
//        productRepository.save(battery1);
//        productRepository.save(battery2);
//        productRepository.save(battery3);
//
//        Product propeller1 = new Product(longStock, "214454007", "Dual blade", retailFloat += 500, "propeller", "F22 Propeller", longStock += 100, longStock += 123, longStock, false, "notesTest", "notesTest", "https://cdn.shopify.com/s/files/1/0024/9803/5810/products/643487-Product-1-I_2240x.jpg?v=1572320430", 0, longStock);
//        Product propeller2 = new Product(longStock, "244454008", "Triple Blade", retailFloat += 700, "propeller", "F33 Propeller", longStock += 100, longStock += 123, longStock, false, "notesTest", "notesTest", "https://m.media-amazon.com/images/I/41uw6jVUdtS._AC_UF894,1000_QL80_.jpg", 0, longStock);
//        Product propeller3 = new Product(longStock, "212454009", "Quad Blade", retailFloat += 900, "propeller", "F44 Propeller", longStock += 100, longStock += 123, longStock, false, "notesTest", "notesTest", "https://www.unmannedsystemstechnology.com/wp-content/uploads/2020/05/drone-propeller.png", 0, longStock);
//
//        productRepository.save(propeller1);
//        productRepository.save(propeller2);
//        productRepository.save(propeller3);
//
//        Product camera1 = new Product(longStock, "2114454010", "Camera 1", retailFloat += 500, "camera", "Camera 11", longStock += 100, longStock += 123, longStock, false, "notesTest", "notesTest", "https://cdn.shopify.com/s/files/1/0063/3946/1231/products/mmexport1574955222637_800x800.jpg?v=1616779308", 0, longStock);
//        Product camera2 = new Product(longStock, "2414454011", "Camera 2", retailFloat += 700, "camera", "Camera 22", longStock += 100, longStock += 123, longStock, false, "notesTest", "notesTest", "https://cdn.shopify.com/s/files/1/0063/3946/1231/products/mmexport1610816889862_800x800.jpg?v=1616073826", 0, longStock);
//        Product camera3 = new Product(longStock, "2122454012", "Camera 3", retailFloat += 900, "camera", "Camera 33", longStock += 100, longStock += 123, longStock, false, "notesTest", "notesTest", "https://cdn.shopify.com/s/files/1/0063/3946/1231/products/01_2400x2400.jpg?v=1646165290", 0, longStock);
//
//        productRepository.save(camera1);
//        productRepository.save(camera2);
//        productRepository.save(camera3);
    }
}
