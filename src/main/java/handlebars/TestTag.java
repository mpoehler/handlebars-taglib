package handlebars;

import javax.servlet.jsp.tagext.TagSupport;
import javax.servlet.jsp.JspException;
import java.io.IOException;

public class TestTag extends TagSupport {

    private static final long serialVersionUID = 8775642189432539197L;

    public int doStartTag() throws JspException {
        try {
            pageContext.getOut().write("Hallo Welt");
        } catch (IOException e) {
            throw new JspException("ups.");
        }
        return TagSupport.EVAL_PAGE;
    }
}