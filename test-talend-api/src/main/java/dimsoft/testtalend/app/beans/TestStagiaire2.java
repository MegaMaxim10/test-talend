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
@Table(name = "test_stagiaire_2", catalog = "talend_test_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TestStagiaire2.findAll", query = "SELECT t FROM TestStagiaire2 t")
    , @NamedQuery(name = "TestStagiaire2.findByEntreprise", query = "SELECT t FROM TestStagiaire2 t WHERE t.entreprise = :entreprise")
    , @NamedQuery(name = "TestStagiaire2.findBySecteurDActivite", query = "SELECT t FROM TestStagiaire2 t WHERE t.secteurDActivite = :secteurDActivite")
    , @NamedQuery(name = "TestStagiaire2.findByInterlocuteur", query = "SELECT t FROM TestStagiaire2 t WHERE t.interlocuteur = :interlocuteur")
    , @NamedQuery(name = "TestStagiaire2.findByPositionInterlocuteur", query = "SELECT t FROM TestStagiaire2 t WHERE t.positionInterlocuteur = :positionInterlocuteur")
    , @NamedQuery(name = "TestStagiaire2.findByContactPrincipal", query = "SELECT t FROM TestStagiaire2 t WHERE t.contactPrincipal = :contactPrincipal")
    , @NamedQuery(name = "TestStagiaire2.findByFonction", query = "SELECT t FROM TestStagiaire2 t WHERE t.fonction = :fonction")
    , @NamedQuery(name = "TestStagiaire2.findByTelephone", query = "SELECT t FROM TestStagiaire2 t WHERE t.telephone = :telephone")
    , @NamedQuery(name = "TestStagiaire2.findByEmail", query = "SELECT t FROM TestStagiaire2 t WHERE t.email = :email")
    , @NamedQuery(name = "TestStagiaire2.findByRegionProvince", query = "SELECT t FROM TestStagiaire2 t WHERE t.regionProvince = :regionProvince")
    , @NamedQuery(name = "TestStagiaire2.findByVille", query = "SELECT t FROM TestStagiaire2 t WHERE t.ville = :ville")
    , @NamedQuery(name = "TestStagiaire2.findByQuartier", query = "SELECT t FROM TestStagiaire2 t WHERE t.quartier = :quartier")
    , @NamedQuery(name = "TestStagiaire2.findByLocalisationExacte", query = "SELECT t FROM TestStagiaire2 t WHERE t.localisationExacte = :localisationExacte")
    , @NamedQuery(name = "TestStagiaire2.findByNombreDEmployes", query = "SELECT t FROM TestStagiaire2 t WHERE t.nombreDEmployes = :nombreDEmployes")
    , @NamedQuery(name = "TestStagiaire2.findByFlotte", query = "SELECT t FROM TestStagiaire2 t WHERE t.flotte = :flotte")
    , @NamedQuery(name = "TestStagiaire2.findByNombreDeLigne", query = "SELECT t FROM TestStagiaire2 t WHERE t.nombreDeLigne = :nombreDeLigne")
    , @NamedQuery(name = "TestStagiaire2.findByOperateur", query = "SELECT t FROM TestStagiaire2 t WHERE t.operateur = :operateur")
    , @NamedQuery(name = "TestStagiaire2.findByBuddgetMensuel", query = "SELECT t FROM TestStagiaire2 t WHERE t.buddgetMensuel = :buddgetMensuel")
    , @NamedQuery(name = "TestStagiaire2.findByInternet", query = "SELECT t FROM TestStagiaire2 t WHERE t.internet = :internet")
    , @NamedQuery(name = "TestStagiaire2.findByFai", query = "SELECT t FROM TestStagiaire2 t WHERE t.fai = :fai")
    , @NamedQuery(name = "TestStagiaire2.findByNombreDePc", query = "SELECT t FROM TestStagiaire2 t WHERE t.nombreDePc = :nombreDePc")
    , @NamedQuery(name = "TestStagiaire2.findByBudgetMensuel", query = "SELECT t FROM TestStagiaire2 t WHERE t.budgetMensuel = :budgetMensuel")
    , @NamedQuery(name = "TestStagiaire2.findBySiteWeb", query = "SELECT t FROM TestStagiaire2 t WHERE t.siteWeb = :siteWeb")
    , @NamedQuery(name = "TestStagiaire2.findByNombreDAgences", query = "SELECT t FROM TestStagiaire2 t WHERE t.nombreDAgences = :nombreDAgences")
    , @NamedQuery(name = "TestStagiaire2.findByCommentaire", query = "SELECT t FROM TestStagiaire2 t WHERE t.commentaire = :commentaire")})
public class TestStagiaire2 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false, length = 61)
    private String entreprise;
    @Column(name = "secteur_d_activite", length = 1)
    private String secteurDActivite;
    @Column(length = 1)
    private String interlocuteur;
    @Column(name = "position_interlocuteur", length = 1)
    private String positionInterlocuteur;
    @Column(name = "contact_principal", length = 1)
    private String contactPrincipal;
    @Column(length = 1)
    private String fonction;
    private BigInteger telephone;
    @Column(length = 34)
    private String email;
    @Column(name = "region_province", length = 8)
    private String regionProvince;
    @Column(length = 1)
    private String ville;
    @Column(length = 1)
    private String quartier;
    @Column(name = "localisation_exacte", length = 10)
    private String localisationExacte;
    @Column(name = "nombre_d_employes", length = 10)
    private String nombreDEmployes;
    @Column(name = "flotte_", length = 10)
    private String flotte;
    @Column(name = "nombre_de_ligne", length = 10)
    private String nombreDeLigne;
    @Column(length = 10)
    private String operateur;
    @Column(name = "buddget_mensuel")
    private BigInteger buddgetMensuel;
    @Column(name = "internet_", length = 100)
    private String internet;
    @Column(length = 100)
    private String fai;
    @Column(name = "nombre_de_pc")
    private BigInteger nombreDePc;
    @Column(name = "budget_mensuel")
    private BigInteger budgetMensuel;
    @Column(name = "site_web_", length = 150)
    private String siteWeb;
    @Column(name = "nombre_d_agences")
    private BigInteger nombreDAgences;
    @Column(length = 1000)
    private String commentaire;

    public TestStagiaire2() {
    }

    public TestStagiaire2(String entreprise) {
        this.entreprise = entreprise;
    }

    public String getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(String entreprise) {
        this.entreprise = entreprise;
    }

    public String getSecteurDActivite() {
        return secteurDActivite;
    }

    public void setSecteurDActivite(String secteurDActivite) {
        this.secteurDActivite = secteurDActivite;
    }

    public String getInterlocuteur() {
        return interlocuteur;
    }

    public void setInterlocuteur(String interlocuteur) {
        this.interlocuteur = interlocuteur;
    }

    public String getPositionInterlocuteur() {
        return positionInterlocuteur;
    }

    public void setPositionInterlocuteur(String positionInterlocuteur) {
        this.positionInterlocuteur = positionInterlocuteur;
    }

    public String getContactPrincipal() {
        return contactPrincipal;
    }

    public void setContactPrincipal(String contactPrincipal) {
        this.contactPrincipal = contactPrincipal;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public BigInteger getTelephone() {
        return telephone;
    }

    public void setTelephone(BigInteger telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegionProvince() {
        return regionProvince;
    }

    public void setRegionProvince(String regionProvince) {
        this.regionProvince = regionProvince;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getQuartier() {
        return quartier;
    }

    public void setQuartier(String quartier) {
        this.quartier = quartier;
    }

    public String getLocalisationExacte() {
        return localisationExacte;
    }

    public void setLocalisationExacte(String localisationExacte) {
        this.localisationExacte = localisationExacte;
    }

    public String getNombreDEmployes() {
        return nombreDEmployes;
    }

    public void setNombreDEmployes(String nombreDEmployes) {
        this.nombreDEmployes = nombreDEmployes;
    }

    public String getFlotte() {
        return flotte;
    }

    public void setFlotte(String flotte) {
        this.flotte = flotte;
    }

    public String getNombreDeLigne() {
        return nombreDeLigne;
    }

    public void setNombreDeLigne(String nombreDeLigne) {
        this.nombreDeLigne = nombreDeLigne;
    }

    public String getOperateur() {
        return operateur;
    }

    public void setOperateur(String operateur) {
        this.operateur = operateur;
    }

    public BigInteger getBuddgetMensuel() {
        return buddgetMensuel;
    }

    public void setBuddgetMensuel(BigInteger buddgetMensuel) {
        this.buddgetMensuel = buddgetMensuel;
    }

    public String getInternet() {
        return internet;
    }

    public void setInternet(String internet) {
        this.internet = internet;
    }

    public String getFai() {
        return fai;
    }

    public void setFai(String fai) {
        this.fai = fai;
    }

    public BigInteger getNombreDePc() {
        return nombreDePc;
    }

    public void setNombreDePc(BigInteger nombreDePc) {
        this.nombreDePc = nombreDePc;
    }

    public BigInteger getBudgetMensuel() {
        return budgetMensuel;
    }

    public void setBudgetMensuel(BigInteger budgetMensuel) {
        this.budgetMensuel = budgetMensuel;
    }

    public String getSiteWeb() {
        return siteWeb;
    }

    public void setSiteWeb(String siteWeb) {
        this.siteWeb = siteWeb;
    }

    public BigInteger getNombreDAgences() {
        return nombreDAgences;
    }

    public void setNombreDAgences(BigInteger nombreDAgences) {
        this.nombreDAgences = nombreDAgences;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (entreprise != null ? entreprise.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TestStagiaire2)) {
            return false;
        }
        TestStagiaire2 other = (TestStagiaire2) object;
        if ((this.entreprise == null && other.entreprise != null) || (this.entreprise != null && !this.entreprise.equals(other.entreprise))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dimsoft.testtalend.app.beans.TestStagiaire2[ entreprise=" + entreprise + " ]";
    }
    
}
