/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courses;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Fayez
 */
@Entity
@Table(name = "tbl_courses", catalog = "courses", schema = "")
@NamedQueries({
    @NamedQuery(name = "TblCourses.findAll", query = "SELECT t FROM TblCourses t"),
    @NamedQuery(name = "TblCourses.findByCourseId", query = "SELECT t FROM TblCourses t WHERE t.courseId = :courseId"),
    @NamedQuery(name = "TblCourses.findByCourseCode", query = "SELECT t FROM TblCourses t WHERE t.courseCode = :courseCode"),
    @NamedQuery(name = "TblCourses.findByCourseName", query = "SELECT t FROM TblCourses t WHERE t.courseName = :courseName"),
    @NamedQuery(name = "TblCourses.findByDescription", query = "SELECT t FROM TblCourses t WHERE t.description = :description"),
    @NamedQuery(name = "TblCourses.findByType", query = "SELECT t FROM TblCourses t WHERE t.type = :type"),
    @NamedQuery(name = "TblCourses.findByNbOfCredits", query = "SELECT t FROM TblCourses t WHERE t.nbOfCredits = :nbOfCredits"),
    @NamedQuery(name = "TblCourses.findByLab", query = "SELECT t FROM TblCourses t WHERE t.lab = :lab")})
public class TblCourses implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "course_id")
    private Integer courseId;
    @Basic(optional = false)
    @Column(name = "course_code")
    private String courseCode;
    @Basic(optional = false)
    @Column(name = "course_name")
    private String courseName;
    @Column(name = "description")
    private String description;
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @Column(name = "nb_of_credits")
    private int nbOfCredits;
    @Basic(optional = false)
    @Column(name = "lab")
    private String lab;

    public TblCourses() {
    }

    public TblCourses(Integer courseId) {
        this.courseId = courseId;
    }

    public TblCourses(Integer courseId, String courseCode, String courseName, int nbOfCredits, String lab) {
        this.courseId = courseId;
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.nbOfCredits = nbOfCredits;
        this.lab = lab;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        Integer oldCourseId = this.courseId;
        this.courseId = courseId;
        changeSupport.firePropertyChange("courseId", oldCourseId, courseId);
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        String oldCourseCode = this.courseCode;
        this.courseCode = courseCode;
        changeSupport.firePropertyChange("courseCode", oldCourseCode, courseCode);
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        String oldCourseName = this.courseName;
        this.courseName = courseName;
        changeSupport.firePropertyChange("courseName", oldCourseName, courseName);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        String oldDescription = this.description;
        this.description = description;
        changeSupport.firePropertyChange("description", oldDescription, description);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        String oldType = this.type;
        this.type = type;
        changeSupport.firePropertyChange("type", oldType, type);
    }

    public int getNbOfCredits() {
        return nbOfCredits;
    }

    public void setNbOfCredits(int nbOfCredits) {
        int oldNbOfCredits = this.nbOfCredits;
        this.nbOfCredits = nbOfCredits;
        changeSupport.firePropertyChange("nbOfCredits", oldNbOfCredits, nbOfCredits);
    }

    public String getLab() {
        return lab;
    }

    public void setLab(String lab) {
        String oldLab = this.lab;
        this.lab = lab;
        changeSupport.firePropertyChange("lab", oldLab, lab);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (courseId != null ? courseId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblCourses)) {
            return false;
        }
        TblCourses other = (TblCourses) object;
        if ((this.courseId == null && other.courseId != null) || (this.courseId != null && !this.courseId.equals(other.courseId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "courses.TblCourses[ courseId=" + courseId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
