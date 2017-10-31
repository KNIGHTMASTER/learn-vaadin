package com.zisal.learn.vaadin.constant;


/**
 * <p>
 *      A Bunch of interfaces to represent <b>Constant</b> values for common usage in Application
 * </p>
 *
 * Created on 9/22/2015 : 4:19 PM.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface GeneralConstant {

    interface Punctuation {
        String SPACE 					= " ";
        String COLON 					= ":";
        String SEMI_COLON 				= ";";
        String COMMA 					= ",";
        String QUESTION 				= "?";
        String UNDERSCORE 				= "_";
        String HYPHEN 					= "-";
        String SLASH 					= "/";
        String DOUBLE_SLASH 			= "//";
        String EMPTY 					= "";
        String PIPE 					= "|";
        String LEFT_PARENTHESES         = "(";
        String RIGHT_PARENTHESES        = ")";
    }

    interface BinaryValue{
        int MINUS_ONE 			= -1;
        int ZERO 				= 0;
        int ONE 				= 1;
        String MINUS_ONE_STRING	= "-1";
        String ZERO_STRING 		= "0";
        String ONE_STRING 		= "1";
    }

    interface WebServiceCode{
        int SUCCESS 			= 200;
        String HTTP 			= "http";
        String HTTPS 			= "https";
    }
}
