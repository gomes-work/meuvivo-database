package com.vivo.database.repository;

import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by joaogomes on 09/05/17.
 */
public class ProcConsultaDadosCliente extends StoredProcedure {

    public static final String PROC_NAME = "SOA_OW.PRC_CONSULTADADOSCLIENTE";

    public static final String VI_DSEMAIL = "VI_DSEMAIL";
    public static final String VI_TPCLIENTE = "VI_TPCLIENTE";
    public static final String VI_NRDOCUMENTO = "VI_NRDOCUMENTO";
    public static final String VI_CDAREAREGISTRO = "VI_CDAREAREGISTRO";
    public static final String VI_NRTELEFONE = "VI_NRTELEFONE";
    public static final String VO_DSNOME = "VO_DSNOME";
    public static final String VO_TPCLIENTE = "VO_TPCLIENTE";
    public static final String VO_NRDOCUMENTO = "VO_NRDOCUMENTO";
    //  public static final String VO_CDTIPOACESSO = "VO_CDTIPOACESSO";
    public static final String VO_IDFB = "VO_IDFB";
    public static final String VO_INDATIVOFB = "VO_INDATIVOFB";
    public static final String VO_DSEMAIL = "VO_DSEMAIL";
    public static final String VO_IDPESSOA = "VO_IDPESSOA";
    public static final String VO_DSURLFACEBOOK = "VO_DSURLFACEBOOK";
    public static final String VO_CANAL = "VO_CANAL";
    public static final String VO_CDERRO = "VO_CDERRO";
    public static final String VO_DSERRO = "VO_DSERRO";

    /**
     *
     * @param dataSource
     */
    public ProcConsultaDadosCliente(final DataSource dataSource) {
        super(dataSource, PROC_NAME);

        declareParameterConsutarDadosCliente();
        compile();
    }

    /**
     * parametros da procedure PRC_CONSULTADADOSCLIENTE
     */
    public void declareParameterConsutarDadosCliente() {
        declareParameter(new SqlParameter(VI_DSEMAIL, Types.VARCHAR));
        declareParameter(new SqlParameter(VI_TPCLIENTE, Types.VARCHAR));
        declareParameter(new SqlParameter(VI_NRDOCUMENTO, Types.VARCHAR));
        declareParameter(new SqlParameter(VI_CDAREAREGISTRO, Types.INTEGER));
        declareParameter(new SqlParameter(VI_NRTELEFONE, Types.INTEGER));
        declareParameter(new SqlOutParameter(VO_DSNOME, Types.VARCHAR));
        declareParameter(new SqlOutParameter(VO_TPCLIENTE, Types.VARCHAR));
        declareParameter(new SqlOutParameter(VO_NRDOCUMENTO, Types.VARCHAR));
        // declareParameter(new SqlOutParameter(VO_CDTIPOACESSO, Types.INTEGER));
        declareParameter(new SqlOutParameter(VO_IDFB, Types.VARCHAR));
        declareParameter(new SqlOutParameter(VO_INDATIVOFB, Types.INTEGER));
        declareParameter(new SqlOutParameter(VO_DSEMAIL, Types.VARCHAR));
        declareParameter(new SqlOutParameter(VO_IDPESSOA, Types.INTEGER));
        declareParameter(new SqlOutParameter(VO_CANAL, Types.VARCHAR));
        declareParameter(new SqlOutParameter(VO_DSURLFACEBOOK, Types.VARCHAR));
        declareParameter(new SqlOutParameter(VO_CDERRO, Types.INTEGER));
        declareParameter(new SqlOutParameter(VO_DSERRO, Types.VARCHAR));
    }

    /**
     *
     * @param email
     * @param tipoCliente
     * @param numDocumento
     * @param codigoArea
     * @param numTelefone
     * @return
     */
    public Map<String, Object> execute(final String email, final String tipoCliente, final String numDocumento, final Integer codigoArea, final String numTelefone) {

        final Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put(VI_DSEMAIL, email);
        parameters.put(VI_TPCLIENTE, tipoCliente);
        parameters.put(VI_NRDOCUMENTO, numDocumento);
        parameters.put(VI_CDAREAREGISTRO, codigoArea);
        parameters.put(VI_NRTELEFONE, numTelefone);

        return super.execute(parameters);
    }

}
