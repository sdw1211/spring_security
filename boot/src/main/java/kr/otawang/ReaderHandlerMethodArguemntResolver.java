package kr.otawang;


import org.springframework.core.MethodParameter;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import kr.otawang.model.User;

public class ReaderHandlerMethodArguemntResolver implements HandlerMethodArgumentResolver {

	@Override
	public Object resolveArgument(MethodParameter arg0, ModelAndViewContainer arg1, NativeWebRequest arg2,
			WebDataBinderFactory arg3) throws Exception {
		// TODO Auto-generated method stub
		Authentication auth = (Authentication)arg2.getUserPrincipal();
		return auth != null && auth.getPrincipal() instanceof User ? auth.getPrincipal() : null;
	}

	@Override
	public boolean supportsParameter(MethodParameter arg0) {
		// TODO Auto-generated method stub
		return User.class.isAssignableFrom(arg0.getParameterType());
	}
	
}
