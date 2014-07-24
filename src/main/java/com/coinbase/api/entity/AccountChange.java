package com.coinbase.api.entity;

import org.joda.money.Money;
import org.joda.time.DateTime;

import com.coinbase.api.deserializer.MoneyDeserializer;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class AccountChange {
    
    public static class Cache {
        
        public enum Category {
            TRANSFER("transfer"),
            TRANSACTION("tx");
            
            private String _value;
            private Category(String value) { this._value = value; }
            
            @JsonValue
            public String toString() { return this._value; }
            
            @JsonCreator
            public static Category create(String val) {
                for (Category category : Category.values()) {
                    if (category.toString().equalsIgnoreCase(val)) {
                        return category;
                    }
                }
                return null;
            }
        }
        
        private Category _category;
        private Boolean _fiat;
        private Boolean _notes_present;
        private User _other_user;
        
        public Category getCategory() {
            return _category;
        }

        public void setCategory(Category category) {
            _category = category;
        }

        public Boolean isFiat() {
            return _fiat;
        }

        public void setFiat(Boolean fiat) {
            _fiat = fiat;
        }

        public Boolean isNotesPresent() {
            return _notes_present;
        }

        public void setNotesPresent(Boolean notes_present) {
            _notes_present = notes_present;
        }

        public User getOtherUser() {
            return _other_user;
        }

        public void setOtherUser(User other_user) {
            _other_user = other_user;
        }
        
    }

    private String _id;
    private String _transaction_id;
    private DateTime _createdAt;
    private Money _amount;
    private Boolean _confirmed;
    private Cache _cache;

    public Cache getCache() {
        return _cache;
    }

    public void setCache(Cache cache) {
        _cache = cache;
    }

    public Boolean isConfirmed() {
        return _confirmed;
    }

    public void setConfirmed(Boolean confirmed) {
        _confirmed = confirmed;
    }

    public String getId() {
        return _id;
    }
    
    public void setId(String id) {
        _id = id;
    }
    
    public DateTime getCreatedAt() {
        return _createdAt;
    }
    
    public void setCreatedAt(DateTime createdAt) {
        _createdAt = createdAt;
    }
    
    public Money getAmount() {
        return _amount;
    }
    
    @JsonDeserialize(using=MoneyDeserializer.class)
    public void setAmount(Money amount) {
        _amount = amount;
    }
    
    public String getTransactionId() {
        return _transaction_id;
    }

    public void setTransactionId(String transaction_id) {
        _transaction_id = transaction_id;
    }
}
