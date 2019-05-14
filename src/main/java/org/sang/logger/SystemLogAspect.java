package org.sang.logger;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.sang.common.UserUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

@Aspect
@Component
public class SystemLogAspect {

//    @Autowired
//    private UserLogService userLogService;

    private static final Logger logger = LoggerFactory.getLogger(SystemLogAspect.class);

    Logger logBussiness = LogUtils.getBussinessLogger();

    @Pointcut("@annotation(org.sang.logger.SystemControllerLog)")
    public void controllerAspect() {
    }

    @After("controllerAspect()")
    public void doAfter(JoinPoint joinPoint) {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        StringBuffer bussinessLog = new StringBuffer();
        bussinessLog.append(UserUtils.getCurrentHr().getName() + "_");
        String ip = IpAdrressUtil.getIpAdrress(request);
//        bussinessLog.append(ip);
        try {
            //*========控制台输出=========*//
            System.out.println("==============后置通知开始==============");
            System.out.println("请求方法" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName()));
            bussinessLog.append(joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName());
            System.out.println("方法描述：" + getControllerMethodDescription(joinPoint));
            bussinessLog.append("_" + getControllerMethodDescription(joinPoint) + "_");
            //System.out.println("请求人："+user.getUsername());
            Object[] args = joinPoint.getArgs();
            for (int i = 0; i < args.length; i++) {
                System.out.println("第" + (i + 1) + "个参数为:" + args[i]);
                bussinessLog.append("第" + (i + 1) + "个参数为:" + args[i]);
            }

            System.out.println("请求ip:" + ip);
            bussinessLog.append("请求ip:_" + ip);
//            System.out.println(new Date());
            //*========数据库日志=========*//
//            Date date = new Date();
//            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            UserLog userLog = new UserLog(getControllerMethodDescription(joinPoint), user.getUsername(), ip,df.format(new Date() ));
//            System.out.println(df.format(new Date()));
//            System.out.println(new Date());
//            int row = userLogService.insert(userLog);
            logBussiness.info(bussinessLog.toString());

        } catch (Exception e) {
            //记录本地异常日志
            logger.error("==前置通知异常==");
            logger.error("异常信息：{}", e.getMessage());
        }
    }


    /**
     * @author changyaofang
     * @Description 获取注解中对方法的描述信息 用于Controller层注解
     * @date 2018年9月3日 上午12:01
     */
    public static String getControllerMethodDescription(JoinPoint joinPoint) throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();//目标方法名
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    description = method.getAnnotation(SystemControllerLog.class).description();
                    break;
                }
            }
        }
        return description;
    }


}

