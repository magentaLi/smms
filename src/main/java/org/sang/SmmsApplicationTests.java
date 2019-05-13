package org.sang;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sang.bean.Product;
import org.sang.bean.Supplier;
import org.sang.bean.User;
import org.sang.bean.Warehousing;

import org.sang.logger.LogUtils;
import org.sang.mapper.ProductMapper;
import org.sang.mapper.SupplierMapper;
import org.sang.mapper.UserMapper;
import org.sang.mapper.WarehousingMapper;

import org.sang.service.UserServiceImpl;
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
        return;
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


}
