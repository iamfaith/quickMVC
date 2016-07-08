import freemarker.template.*;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by faith on 16/5/17.
 */
public class TestFreeMarker {

    @Test
    public void output() {
        System.out.println(System.getProperty("user.dir")+"/src/test/rescources/template");
    }


    @Test
    public void init() throws Exception {
        Configuration cfg = new Configuration();
        String filePath = System.getProperty("user.dir")+"/src/test/rescources/template";
        cfg.setDirectoryForTemplateLoading(new File(filePath));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
      //  cfg.setLogTemplateExceptions(false);

        /* ------------------------------------------------------------------------ */
        /* You usually do these for MULTIPLE TIMES in the application life-cycle:   */

        /* Create a data-model */
        Map root = new HashMap();
        root.put("user", "Big Joe");
        root.put("latestProduct", "23333");

        /* Get the template (uses cache internally) */
        Template temp = cfg.getTemplate("test.ftlh");

        /* Merge data-model with template */
        Writer out = new OutputStreamWriter(System.out);
        temp.process(root, out);
        // Note: Depending on what `out` is, you may need to call `out.close()`.
        // This is usually the case for file output, but not for servlet output.arker的模版文件位置


    }



}
