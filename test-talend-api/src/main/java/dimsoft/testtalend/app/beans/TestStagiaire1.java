/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dimsoft.testtalend.app.beans;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ndadji Maxime
 */
@Entity
@Table(name = "test_stagiaire_1", catalog = "talend_test_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TestStagiaire1.findAll", query = "SELECT t FROM TestStagiaire1 t")
    , @NamedQuery(name = "TestStagiaire1.findByRaisonSociale", query = "SELECT t FROM TestStagiaire1 t WHERE t.raisonSociale = :raisonSociale")
    , @NamedQuery(name = "TestStagiaire1.findByNbresDemployesNomEntreprise", query = "SELECT t FROM TestStagiaire1 t WHERE t.nbresDemployesNomEntreprise = :nbresDemployesNomEntreprise")
    , @NamedQuery(name = "TestStagiaire1.findByNomEtPrenomDuResponsable", query = "SELECT t FROM TestStagiaire1 t WHERE t.nomEtPrenomDuResponsable = :nomEtPrenomDuResponsable")
    , @NamedQuery(name = "TestStagiaire1.findByContact", query = "SELECT t FROM TestStagiaire1 t WHERE t.contact = :contact")
    , @NamedQuery(name = "TestStagiaire1.findBySituationGeographique", query = "SELECT t FROM TestStagiaire1 t WHERE t.situationGeographique = :situationGeographique")
    , @NamedQuery(name = "TestStagiaire1.findByVotreExistantFixeMobileInternetCug", query = "SELECT t FROM TestStagiaire1 t WHERE t.votreExistantFixeMobileInternetCug = :votreExistantFixeMobileInternetCug")
    , @NamedQuery(name = "TestStagiaire1.findByObservation", query = "SELECT t FROM TestStagiaire1 t WHERE t.observation = :observation")})
public class TestStagiaire1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "raison_sociale", length = 20)
    private String raisonSociale;
    @Id
    @Basic(optional = false)
    @Column(name = "nbres_demployes___nom_entreprise", nullable = false, length = 28)
    private String nbresDemployesNomEntreprise;
    @Column(name = "nom_et_prenom_du_responsable", length = 15)
    private String nomEtPrenomDuResponsable;
    private BigInteger contact;
    @Column(name = "situation_geographique", length = 19)
    private String situationGeographique;
    @Column(name = "votre_existant__fixe__mobile_internet_cug", length = 22)
    private String votreExistantFixeMobileInternetCug;
    @Column(length = 16)
    private String observation;

    public TestStagiaire1() {
    }

    public TestStagiaire1(String nbresDemployesNomEntreprise) {
        this.nbresDemployesNomEntreprise = nbresDemployesNomEntreprise;
    }

    public String getRaisonSociale() {
        return raisonSociale;
    }

    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }

    public String getNbresDemployesNomEntreprise() {
        return nbresDemployesNomEntreprise;
    }

    public void setNbresDemployesNomEntreprise(String nbresDemployesNomEntreprise) {
        this.nbresDemployesNomEntreprise = nbresDemployesNomEntreprise;
    }

    public String getNomEtPrenomDuResponsable() {
        return nomEtPrenomDuResponsable;
    }

    public void setNomEtPrenomDuResponsable(String nomEtPrenomDuResponsable) {
        this.nomEtPrenomDuResponsable = nomEtPrenomDuResponsable;
    }

    public BigInteger getContact() {
        return contact;
    }

    public void setContact(BigInteger contact) {
        this.contact = contact;
    }

    public String getSituationGeographique() {
        return situationGeographique;
    }

    public void setSituationGeographique(String situationGeographique) {
        this.situationGeographique = situationGeographique;
    }

    public String getVotreExistantFixeMobileInternetCug() {
        return votreExistantFixeMobileInternetCug;
    }

    public void setVotreExistantFixeMobileInternetCug(String votreExistantFixeMobileInternetCug) {
        this.votreExistantFixeMobileInternetCug = votreExistantFixeMobileInternetCug;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nbresDemployesNomEntreprise != null ? nbresDemployesNomEntreprise.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TestStagiaire1)) {
            return false;
        }
        TestStagiaire1 other = (TestStagiaire1) object;
        if ((this.nbresDemployesNomEntreprise == null && other.nbresDemployesNomEntreprise != null) || (this.nbresDemployesNomEntreprise != null && !this.nbresDemployesNomEntreprise.equals(other.nbresDemployesNomEntreprise))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dimsoft.testtalend.app.beans.TestStagiaire1[ nbresDemployesNomEntreprise=" + nbresDemployesNomEntreprise + " ]";
    }
    
}
