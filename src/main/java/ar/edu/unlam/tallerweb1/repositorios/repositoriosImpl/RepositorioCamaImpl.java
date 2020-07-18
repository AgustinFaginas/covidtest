package ar.edu.unlam.tallerweb1.repositorios.repositoriosImpl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.Query;

import ar.edu.unlam.tallerweb1.repositorios.RepositorioCama;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Asignacion;
import ar.edu.unlam.tallerweb1.modelo.Cama;
import ar.edu.unlam.tallerweb1.modelo.Institucion;
import ar.edu.unlam.tallerweb1.modelo.listas.CamaInstitucion;

@Repository("repositorioCama")
@Transactional
public class RepositorioCamaImpl implements RepositorioCama {
    
	@Inject
    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioCamaImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("deprecation")
	@Override
    public Cama consultarCamaPorId(Long id) {
        return (Cama) sessionFactory.getCurrentSession().createCriteria(Cama.class).add(Restrictions.eq("id", id))
                .uniqueResult();
    }

    @Override
    public void registrarCama(Cama cama) {
        sessionFactory.getCurrentSession().save(cama);
    }

    @SuppressWarnings({ "unchecked", "deprecation" })
	@Override
    public List<Cama> obtenerCamas() {
    	
        return sessionFactory.getCurrentSession().createCriteria(Cama.class)
                .list();
    }

    @SuppressWarnings({ "unchecked", "deprecation" })
	@Override
    public List<Cama> obtenerCamasPorInstitucion(Institucion institucion) {
        return sessionFactory.getCurrentSession().createCriteria(Cama.class)
                .add(Restrictions.eq("institucion", institucion))
                .list();
    }

    @SuppressWarnings({ "unchecked", "deprecation" })
	@Override
    public List<Cama> obtenerCamasOcupadasPorInstitucion(Institucion institucion) {
       
            List<Cama> camasOcupadas = sessionFactory.getCurrentSession().createCriteria(Asignacion.class)
		            					.setProjection(Projections.projectionList()
					                	.add(Projections.property("cama"), "cama"))
					            		.add(Restrictions.isNull("motivoEgreso"))
					                    .list();

            for (Cama cama: camasOcupadas) { 
            	if (cama.getInstitucion().equals(institucion)) {
                	camasOcupadas.remove(cama);
				}
    		}
            return camasOcupadas;
    }

    @SuppressWarnings({ "unchecked", "deprecation" })
	@Override
    public List<Cama> obtenerTotalDeCamasOcupadas() {
       
            return sessionFactory.getCurrentSession().createCriteria(Asignacion.class)
            		.setProjection(Projections.projectionList()
                	 .add(Projections.property("cama"), "cama"))
            		.add(Restrictions.isNull("motivoEgreso"))
                    .list();
    }
    
    @SuppressWarnings({ "unchecked" })
    public List<CamaInstitucion> obtenerCantidadDeCamasOcupadasPorInstitucion(Institucion institucion) {
        
        String hql = "SELECT new ar.edu.unlam.tallerweb1.modelo.listas.CamaInstitucion(c, i, count(*)) "
        		   + "FROM Cama as c JOIN Institucion as i ON c.institucion = i "
        		   + "JOIN Asignacion as a ON a.cama = c "
        		   + "WHERE c.institucion = " + institucion + ""
        		   + "AND a.horaEgreso IS NULL";

        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        
        return query.getResultList();
    }
    
    @SuppressWarnings({ "unchecked" })
    public List<CamaInstitucion> obtenerCantidadDeCamasOcupadasDeCadaInstitucion() {
        
        String hql = "SELECT new ar.edu.unlam.tallerweb1.modelo.listas.CamaInstitucion(c, i, count(*)) "
        		   + "FROM Cama as c JOIN Institucion as i ON c.institucion = i "
        		   + "JOIN Asignacion as a ON a.cama = c "
        		   + "WHERE c.institucion NOT IN (SELECT a.cama "
        		   							   + "FROM Asignacion as a "
        		   							   + "WHERE a.cama = c"
        		   							   + "AND a.horaEgreso IS NULL)"
        		   + "GROUP BY c.institucion";

        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        
        return query.getResultList();
    }
    
    @SuppressWarnings({ "unchecked" })
    public List<CamaInstitucion> obtenerCamasPorInstitucionConSuInstitucion(Institucion institucion) {
        
        String hql = "select new ar.edu.unlam.tallerweb1.modelo.CamaInstitucion(c, i) from Cama as c JOIN Institucion as i ON c.institucion = i where c.institucion = " + institucion + ";";

        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        
        return query.getResultList();
    }

    @SuppressWarnings({ "unchecked" })
    public List<CamaInstitucion> obtenerCamasTotalesConSuInstitucion() {
        
        String hql = "select new ar.edu.unlam.tallerweb1.modelo.CamaInstitucion(c, i) from Cama as a JOIN Institucion as i ON c.institucion = i";

        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        
        return query.getResultList();
    }
    
    @SuppressWarnings({ "unchecked" })
    public List<CamaInstitucion> obtenerCamasTotalesDisponiblesConSuInstitucion() {
        
        String hql = "SELECT new ar.edu.unlam.tallerweb1.modelo.listas.CamaInstitucion(c, i) "
        			+ "FROM Cama as c JOIN Institucion as i ON c.institucion = i "
        			+ "WHERE c NOT IN (SELECT a.cama " + 
					        		"FROM Asignacion as a " + 
					        		"WHERE a.cama = c " + 
					        		"AND a.horaEgreso IS NULL)";

        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        
        return query.getResultList();
    }

}
