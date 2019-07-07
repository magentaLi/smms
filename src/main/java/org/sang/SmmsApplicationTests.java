package org.sang;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.sang.bean.*;

import org.sang.common.DateConverter;
import org.sang.logger.LogUtils;
import org.sang.mapper.*;

import org.sang.service.*;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author magentaLi
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SmmsApplicationTests {

    @Autowired
    ProductMapper productMapper;
    @Autowired
    SupplierMapper supplierMapper;
    @Autowired
    WarehousingMapper warehousingMapper;
    @Autowired
    UserMapper userMapper;

    @Test
    public void test01() {
        Product product = new Product();
        product.setProductCode("产品代码");
        product.setProductName("产品名称");
        product.setProductCategoryId(1);
        Date dNow = new Date();
        product.setProductionDate(dNow);
        product.setGuaranteePeriod(90);
        product.setProductPrice(400.0);

        //添加商品
//        System.out.println(productMapper.addProduct(product));
        //修改商品
//        System.out.println(productMapper.updateProduct(product));
        //查询所有
        List<Product> allProduct = productMapper.getAllProduct();
        System.out.println(allProduct.toString());
//        查询单个
//        Product productByProductCode = productMapper.getProductByProductCode("11111111");
//        System.out.println(productByProductCode.toString());
        //删除商品
//        productMapper.deleteProduct("产品代码");

    }

    @Test
    public void test02() {
        Supplier supplier = new Supplier();
        supplier.setSupplierCode("供应商代码");
        supplier.setSupplierName("供应商名称");
        supplier.setSupplierAddress("供应商地址");
        supplier.setSupplierTel("17711040973");
        supplier.setSupplierEMail("1404895946@qq.com");
        supplier.setSupplierFax("8596542");
        supplier.setSupplierReputation(1);
        supplier.setSupplierLoan(2000.0);

//        supplierMapper.addSupplier(supplier);
//        supplierMapper.updateSupplier(supplier);
//        List<Supplier> allSupplier = supplierMapper.getAllSupplier();
//        System.out.println(allSupplier);
//        Supplier supplier1 = supplierMapper.getSupplierBySupplierCode("供应商代码");
//        System.out.println(supplier1);
//        supplierMapper.deleteSupplier("供应商代码");
    }

    @Test
    public void test() {
        Warehousing warehousing = new Warehousing();
        warehousing.setPaidMoney(333.0);
        warehousing.setProductCount(100);
        warehousing.setSupplierCode("CCCC");
        warehousing.setWarehousingId(1234567);
        warehousing.setProductPrice(3.0);
        //warehousing.setProductCode();
        //warehousing.setWarehousingDate("2019-04-24");
        //System.out.println(warehousingMapper.addWarehousing(warehousing));
        //System.out.println(warehousingMapper.deleteWarehousingBydId(1111));
        //System.out.println(warehousingMapper.getWarehousing());

        Logger log = LogUtils.getExceptionLogger();
        Logger log1 = LogUtils.getBussinessLogger();
        Logger log2 = LogUtils.getDBLogger();
        warehousingMapper.getWarehousingById(1234567);
        log.error("getExceptionLogger===日志测试");
        log1.info("getBussinessLogger===日志测试");
        log2.debug("getDBLogger===日志测试");
        //System.out.println(warehousingMapper.getWarehousingById(1234567));
        //System.out.println(warehousingMapper.updateWarehousing(warehousing));
    }


    @Autowired
    UserServiceImpl userServiceImpl;

    @Test
    public void test05() {
        List<User> users = userServiceImpl.getUsers(1, 2, "", "", "");
        System.out.println(users.size());
        System.out.println(users);
    }

    @Test
    public void test06() {
        String res = "4,5,6,3";
        String[] split = res.split(",");
        System.out.println(Arrays.asList(split));
    }

    @Test
    public void test07() {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            FileReader fr = new FileReader("D:\\IDEA-WorkSpace\\smms\\log\\login\\smms_login.log");
            BufferedReader bf = new BufferedReader(fr);
            String str;
            // 按行读取字符串
            while ((str = bf.readLine()) != null) {
                arrayList.add(str);
            }
            bf.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String patternStr1 = "[0-9]{4}[-][0-9]{1,2}[-][0-9]{1,2}[ ][0-9]{1,2}[:][0-9]{1,2}[:][0-9]{1,2}";
        String patternStr2 = "(?<=\').*?(?=\')";
        Pattern pattern1 = Pattern.compile(patternStr1);
        Pattern pattern2 = Pattern.compile(patternStr2);
        HashMap<String, String> map = new HashMap<>();
        String time = null;
        String name = null;
        for (String str : arrayList) {
            Matcher matcher1 = pattern1.matcher(str);
            if (matcher1.find()) {
                time = matcher1.group();
            }
            Matcher matcher2 = pattern2.matcher(str);
            if (matcher2.find()) {
                name = matcher2.group();
            }
            map.put(time, name);
        }
        Set<String> strings = map.keySet();
        for (String s : strings) {
            String s1 = map.get(s);
            System.out.println("key=" + s + " " + "value=" + s1);
        }
    }

    @Test
    public void test08() {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            FileReader fr = new FileReader("D:\\IDEA-WorkSpace\\smms\\log\\bussiness\\smms_bussiness.log");
            BufferedReader bf = new BufferedReader(fr);
            String str;
            // 按行读取字符串
            while ((str = bf.readLine()) != null) {
                arrayList.add(str);
            }
            bf.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList<BusinessLog> logs = new ArrayList<>();
        for (String str : arrayList) {
            String substring = str.substring(83);
            String[] s = substring.split("_");
            BusinessLog businessLog = new BusinessLog(s[0], s[1], s[2], s[4]);
            logs.add(businessLog);
        }
        System.out.println(logs);
    }

    @Autowired
    WastageService wastageService;

    @Test
    public void test10() {
//        Wastage wastage = new Wastage();
//        wastage.setProductCode("11111111");
//        wastage.setAddOrSub(0);
//        wastage.setNum(10);
//        wastage.setReason("我擦");
//        int i = wastageService.addWastage(wastage);
//        System.out.println(i);
//        ArrayList<Wastage> allWastage = wastageService.getAllWastage();
//        System.out.println(allWastage);
        ArrayList<Wastage> wastageByProductCode = wastageService.getWastageByProductCode("11111111");
        System.out.println(wastageByProductCode);
    }

    @Autowired
    UserService userService;

    @Test
    public void test11() {
        Long aLong = new Long(10);
        User userById = userService.getUserById(aLong);
        System.out.println(userById);
    }

    @Autowired
    ReturnGoodMapper returnGoodMapper;

    @Test
    public void test12() {
        ReturnGood returnGood = new ReturnGood();
        returnGood.setProductCode("11111111");
        returnGood.setReturnCount(3);
        returnGood.setReturnReason("太难喝了");
        returnGood.setReturnDate(new Date());
        returnGoodMapper.insertReturnGood(returnGood);
    }

    @Test
    public void test13() {
        ArrayList<ReturnGood> returnGood = returnGoodMapper.getReturnGood(0, 5, "22222222", "2019-05-13", "2019-05-14");
        System.out.println(returnGood);
    }

    @Autowired
    DeliveryService deliveryService;

    @Test
    public void test14() {
        List<Delivery> delivery = deliveryService.getDelivery();
        System.out.println(delivery);
    }

    @Autowired
    ProductCategoryService productCategoryService;

    @Test
    public void test15() {
        ArrayList<ProductCategory> productCategory = productCategoryService.getProductCategory(1, 10, "");
        System.out.println(productCategory);
    }

    @Autowired
    UMenuMapper uMenuMapper;

    @Test
    public void test16() {
        List<UMenu> allUMenu = uMenuMapper.getAllUMenu();
        System.out.println(allUMenu);
    }

    @Test
    public void test17() {
        int[] test = {150, 151};
        uMenuMapper.updateSubMenuForRole(6, test);
    }

    @Autowired
    ProductService productService;

    @Test
    public void test18() {
        ArrayList<Product> products = productService.getProducts(1, 10, "11111111", "", "");
        System.out.println(products);
    }

    @Autowired
    RoleService roleService;

    @Test
    public void test19() {
        ArrayList<Integer> roleMenu = roleService.getRoleMenu(6);
        System.out.println(roleMenu);
    }

    @Autowired
    DateConverter dateConverter;

    @Test
    public void test20() {
        Date convert = dateConverter.convert("2015-12-21");
        System.out.println(convert);
    }

    @Autowired
    DeliveryMapper deliveryMapper;

    @Test
    public void test21() {
        Delivery delivery = new Delivery();
        delivery.setDeliveryDate(new Date());
        delivery.setDeliveryObj("李嘉坤");
        delivery.setPaidMoney(100.0);
        delivery.setDeliveryId(132456);
        delivery.setProductCode("11111111");
        delivery.setProductCount(20);
        delivery.setProductPrice(20.3);
        deliveryMapper.addDelivery(delivery);
    }
}
