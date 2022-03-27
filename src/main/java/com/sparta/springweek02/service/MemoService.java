package com.sparta.springweek02.service;


import com.sparta.springweek02.MemoDto.MemoRequestDto;
import com.sparta.springweek02.domain.Memo;
import com.sparta.springweek02.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
@RequiredArgsConstructor
@Service
public class MemoService {

    private final MemoRepository memoRepository;

    @Transactional
    public Long update(Long id, MemoRequestDto requestDto) {
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new NullPointerException("아이디가 존재하지 않습니다.")
        );
        memo.update(requestDto);
        return id;
    }
}