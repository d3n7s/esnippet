package org.mvnsearch.snippet.domain;

import org.hibernate.annotations.Type;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.joda.time.DateTime;
import org.mvnsearch.ridd.domain.RichDomainSupport;
import org.mvnsearch.snippet.domain.extra.Comment;

import javax.persistence.*;
import java.util.List;

/**
 * domain interface for Snippet
 */
@SuppressWarnings({"unchecked"})
@Entity
@Table(name = "snippets")
public class Snippet extends RichDomainSupport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "category_id")
    private Integer categoryId;
    @Column(name = "name")
    private String name;
    @Column(name = "mnemonic")
    private String mnemonic;
    @Column(name = "language")
    private Integer language;
    @Column(name = "icon")
    private Integer icon;
    @Column(name = "author")
    private String author;
    @Column(name = "keywords")
    private String keywords;
    @Column(name = "url")
    private String url;
    @Column(name = "description")
    private String description;
    @Column(name = "code")
    private String code;
    @Column(name = "example")
    private String example;
    @Column(name = "type")
    private String type;
    @Column(name = "level")
    private Integer level;
    @Column(name = "flag")
    private Integer flag;
    @Column(name = "created_at")
    @Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
    private DateTime createdAt;
    @Column(name = "modified_at")
    @Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
    private DateTime modifiedAt;

    /**
     * get id for entity object
     *
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * set id for entity object
     *
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * get title
     *
     * @return title
     */
    public String getName() {
        return name;
    }

    /**
     * set title
     *
     * @param name title
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get created timestamp
     *
     * @return created timestamp
     */
    public DateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * set created timestamp
     *
     * @param createdAt created timestamp
     */
    public void setCreatedAt(DateTime createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * get category id
     *
     * @return category id
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * set category id
     *
     * @param categoryId category id
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * get mnemonic
     *
     * @return mnemonic
     */
    public String getMnemonic() {
        return mnemonic;
    }

    /**
     * set mnemonic
     *
     * @param mnemonic mnemonic
     */
    public void setMnemonic(String mnemonic) {
        this.mnemonic = mnemonic;
    }

    /**
     * get language type
     *
     * @return language type
     */
    public Integer getLanguage() {
        return language;
    }

    /**
     * set language type
     *
     * @param language language type
     */
    public void setLanguage(Integer language) {
        this.language = language;
    }

    /**
     * get icon type
     *
     * @return icon type
     */
    public Integer getIcon() {
        return icon;
    }

    /**
     * set icon type
     *
     * @param icon icon type
     */
    public void setIcon(Integer icon) {
        this.icon = icon;
    }

    /**
     * get author name
     *
     * @return author name
     */
    public String getAuthor() {
        return author;
    }

    /**
     * set author name
     *
     * @param author author name
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * get key words
     *
     * @return key words
     */
    public String getKeywords() {
        return keywords;
    }

    /**
     * set key words
     *
     * @param keywords key words
     */
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    /**
     * get url
     *
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * set url
     *
     * @param url url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * get description
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * set description
     *
     * @param description description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * get code for snippet
     *
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * set code
     *
     * @param code code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * get example code
     *
     * @return example code
     */
    public String getExample() {
        return example;
    }

    /**
     * set exmaple code
     *
     * @param example example code
     */
    public void setExample(String example) {
        this.example = example;
    }

    /**
     * get snippet type, such as file or fragment
     *
     * @return snippet type
     */
    public String getType() {
        return type;
    }

    /**
     * set snippet type
     *
     * @param type snippet type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * get level
     *
     * @return level
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * set level
     *
     * @param level level
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * get flag
     *
     * @return flag
     */
    public Integer getFlag() {
        return flag;
    }

    /**
     * set flag
     *
     * @param flag flag
     */
    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    /**
     * get last modified timestamp
     *
     * @return modified timestamp
     */
    public DateTime getModifiedAt() {
        return modifiedAt;
    }

    /**
     * set last modified timestamp
     *
     * @param modifiedAt modified timestamp
     */
    public void setModifiedAt(DateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    /**
     * add comment for snippet
     *
     * @param comment comment
     */
    public void addComment(Comment comment) {
        comment.setSnippetId(id);
        getHibernateTemplate().save(comment);
    }

    /**
     * find comments for snippet
     *
     * @return comment list
     */
    public List<Comment> findComments() {
        DetachedCriteria criteria = DetachedCriteria.forClass(Comment.class);
        criteria.add(Restrictions.eq("snippetId", this.id));
        criteria.addOrder(Order.desc("id"));
        return getHibernateTemplate().findByCriteria(criteria);
    }
}