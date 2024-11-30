package com.zerobase.config;

import org.apache.commons.collections4.Trie;
import org.apache.commons.collections4.trie.PatriciaTrie;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AppConfig {

    // 회사명 검색 시 autocomplete 기능에 활용되는 PatriciaTrie 데이터 구조
    @Bean
    public Trie<String, String> trie() {
        return new PatriciaTrie<>();
    }

    // PasswordEncoder Bean - 패스워드 암호화를 위한 BCryptPasswordEncoder, 강도는 12로 설정
    @Bean
    public PasswordEncoder passwordEncoder() {
        int strength = 12;  // 암호화 강도 (기본값은 10)
        return new BCryptPasswordEncoder(strength);
    }
}
