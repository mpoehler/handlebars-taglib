package handlebars;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * Created by marco on 24.10.16.
 */
public class PrecompileTag extends TagSupport {
    private static final long serialVersionUID = -1813471827103251333L;

    private static final Logger log = Logger.getLogger(TemplateTag.class.getName());

    private Handlebars handlebars = new Handlebars();

    // name of the template
    private String name;

    private String wrapper;

    public int doStartTag() throws JspException {
        try {
            Template template = handlebars.compileInline("{{precompile \""+name+"\"}}");
            template.apply(null, pageContext.getOut());
        } catch (IOException e) {
            throw new JspException("Ups... something went wrong during template evaluation.", e);
        }
        return TagSupport.EVAL_PAGE;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWrapper(String wrapper) {
        this.wrapper = wrapper;
    }
}
