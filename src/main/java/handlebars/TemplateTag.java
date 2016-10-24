package handlebars;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;

import javax.servlet.jsp.tagext.TagSupport;
import javax.servlet.jsp.JspException;
import java.io.IOException;
import java.util.logging.Logger;

public class TemplateTag extends TagSupport {

    // private static final Logger log = Logger.getLogger(TemplateTag.class.getName());

    private static final long serialVersionUID = 8775642189432539197L;

    private Handlebars handlebars = new Handlebars();

    // name of the template
    private String name;

    // name of the context variable
    private String var;

    public int doStartTag() throws JspException {
        try {
            Template template = handlebars.compile(name);
            template.apply(pageContext.getAttribute(var), pageContext.getOut());
        } catch (IOException e) {
            throw new JspException("Ups... something went wrong during template evaluation.", e);
        }
        return TagSupport.EVAL_PAGE;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVar(String var) {
        this.var = var;
    }
}