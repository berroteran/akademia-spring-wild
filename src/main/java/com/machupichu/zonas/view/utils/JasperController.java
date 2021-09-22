package com.machupichu.zonas.view.utils;

import com.machupichu.zonas.data.repository.UserRepository;
import com.machupichu.zonas.model.BitacoraImpresion;
import com.machupichu.zonas.service.catalogo.BitacoraImpresionService;
import com.machupichu.zonas.view.bean.SessionBackBean;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/jasper")
public class JasperController {

    @Autowired
    BitacoraImpresionService bitacoraImpresionSrv;

    @Autowired
    private JasperUtil jasper;

    @Autowired
    private final UserRepository userRepository = null;


    @RequestMapping(value = "/export", method = RequestMethod.POST)
    @ResponseBody
    public void exporter(@RequestParam Map<String, Object> params, HttpServletResponse response) throws IOException, JRException, SQLException {

        String rptName = params.get("rpt_name") instanceof String ? (String) params.get("rpt_name") : "";
        String type = params.get("rpt_type") instanceof String ? (String) params.get("rpt_type") : "";
        String logBitacora = params.get("log_bitacora") instanceof String ? (String) params.get("log_bitacora") : "";
        String documento = params.get("num_doc") instanceof String ? (String) params.get("num_doc") : "";

        if( type == null || type.isEmpty()) return;

        if(!(logBitacora == null || logBitacora.isEmpty()) && "1".equals(logBitacora)){
            BitacoraImpresion bitacora = new BitacoraImpresion();
            bitacora.setDocumento(documento);
            bitacora.setReporte(rptName);
            bitacora.setFechaImpresion(LocalDateTime.now());
            bitacora.setUsuarioImprime(getUserFromSessino());

            bitacoraImpresionSrv.save(bitacora);
        }

        Map<String, Object> rptParams = new HashMap<>();
        params.entrySet().stream()
                .filter(e -> !("rpt_name".equals(e.getKey()) || "rpt_type".equals(e.getKey())) )
                .forEach( e -> rptParams.put(e.getKey(), e.getValue()));

        String contentType = "application/" + type;
        String contentDisposition = "inline; filename="+ rptName.toUpperCase()
                + "_"+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_hhmmss")) +"." + type;

        response.setContentType(contentType);
        response.setHeader("Content-Disposition", contentDisposition);

        OutputStream out = response.getOutputStream();
        JasperPrint jasperPrint = jasper.exportReport(rptName + ".jrxml", rptParams);
        JasperExportManager.exportReportToPdfStream(jasperPrint, out);

    }

    private String getUserFromSessino() {
        SessionBackBean sessionBackBean = new SessionBackBean(userRepository);
        //SessionBackBean sessionBackBean = new SessionBackBean();
        return sessionBackBean.getUserName() == null ? "NO recuperado" : sessionBackBean.getUserName();
        //return "";
    }

}
