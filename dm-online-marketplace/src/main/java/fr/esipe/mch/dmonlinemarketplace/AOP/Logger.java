package fr.esipe.mch.dmonlinemarketplace.AOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;


@Aspect
@Component
public class Logger {
    @Around(value = "hasRequestMapping() && all()")
    public Object logEntryRest(ProceedingJoinPoint jp) throws Throwable {
        final MethodSignature signature = (MethodSignature) jp.getSignature();
        final Method method = signature.getMethod();
        final RequestMapping controllerAnnotation = method.getAnnotation(RequestMapping.class);
        final String controllerRestPath = (controllerAnnotation.path().length == 0) ? "" : controllerAnnotation.path()[0];

        final RequestMapping controllerMethodAnnotation = method.getAnnotation(RequestMapping.class);
        final RequestMethod controllerRestMethod = (controllerMethodAnnotation.method().length == 0) ? RequestMethod.GET : controllerMethodAnnotation.method()[0];
        String className = jp.getSignature().getDeclaringType().getSimpleName();
        long start = System.currentTimeMillis();
        Object output = jp.proceed();
        long timeExec = System.currentTimeMillis() - start;
        String logMessage = String.format(
                "[%sms][%s][%s][%s()][%s] : %s",
                timeExec,
                controllerRestMethod.toString(),
                controllerRestPath,
                className,
                method.getName(),
                Arrays.toString(jp.getArgs())
        );
        java.util.logging.Logger.getLogger("RestController").info(logMessage);
        return output;
    }
    @Pointcut("execution(* *(..))")
    public void all() {

    }
    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void hasRequestMapping(){

    }
}
