insert into component values(com_sq.nextval, 'Western Digital Elements Desktop 2TB', 'Designed with the same commitment to quality that made WD external drives the number one selling drives in the world.', 'Western Digital', null, null, 149.00);
insert into component values(com_sq.nextval, 'Intel Core i5-2320', 'Intel’s most popular family member adapts and looks better than ever. The 2nd generation Intel Core i5 processor delivers even more performance automatically when you need it and now a better visual PC experience built-in. With Intel Turbo Boost Technology 2.0, the 2nd generation Intel Core i5 processor increases your PC’s speed automatically for your demanding applications. It also includes built-in graphics and a rich set of new features for a stunning and seamless visual PC experience with no additional hardware required. That’s visibly smart performance with a boost.', 'Intel', null, null, 183.00);
insert into component values(com_sq.nextval, 'Dell OptiPlex 990 SFF', 'Dell OptiPlex 990 provides superior security, management capabilities and services for your organization.', 'Dell', null, null, 971.50);
insert into component values(com_sq.nextval, 'Dell UltraSharp U2412M Black', 'Enjoy bright images that can be easily seen from almost any angle. 24-inch Dell UltraSharp with a matrix of IPS and LED backlight, which can be adjusted in height, offers a bright image and rich, saturated colors.', 'Dell', null, null, 301.57);

insert into device values(dev_sq.nextval, null, 12, 'Computer');
insert into device values(dev_sq.nextval, 1000, 10, 'HDD');
insert into device values(dev_sq.nextval, 1000, 11, 'Processor');
insert into device values(dev_sq.nextval, null, 13, 'Monitor');

commit;