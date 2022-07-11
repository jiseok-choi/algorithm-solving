package programmers.level3;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/42579?language=javascript
public class 베스트앨범 {

    class Album implements Comparable<Album> {
        private String genre;
        private int genreTotal;
        private int play;
        private int id;

        public Album(String genre, int genreTotal, int play, int id) {
            this.genre = genre;
            this.genreTotal = genreTotal;
            this.play = play;
            this.id = id;
        }

        @Override
        public int compareTo(Album o) {
            int genreSort = o.genreTotal - this.genreTotal;
            int playSort = o.play - this.play;
            int idSort = this.id - o.id;

            if (genreSort < 0) {
                return genreSort;
            } else if (genreSort > 0) {
                return 1;
            }
            if (playSort < 0) {
                return playSort;
            } else if (playSort > 0) {
                return 1;
            }
            if (idSort < 0) {
                return idSort;
            }
            return 1;
        }
    }

    public int[] solution(String[] genres, int[] plays) {

        Map<String, Integer> genreTotalCntMap = new HashMap<>();

        // 앨범 최대 개수
        for (int i = 0; i < genres.length; i++) {
            int put = genreTotalCntMap.get(genres[i]) == null ? 0 : genreTotalCntMap.get(genres[i]);
            genreTotalCntMap.put(genres[i], put + plays[i]);
        }

        // 앨범 나열 및 정렬
        List<Album> list = new ArrayList<>();
        for (int i = 0; i < genres.length; i++) {
            list.add(new Album(genres[i], genreTotalCntMap.get(genres[i]), plays[i], i));
        }
        list.sort(Comparator.naturalOrder());

        // 결과 구하기
        List<Integer> answerList = new ArrayList<>();

        Map<String, Integer> maxInput = new HashMap<>();
        for (Album album : list) {
            maxInput.put(album.genre, maxInput.get(album.genre) == null ? 1 : maxInput.get(album.genre) + 1);
            if (maxInput.get(album.genre) <= 2) {
                answerList.add(album.id);
            }
        }

        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }


    public static void main(String[] args) {
        베스트앨범 clazz = new 베스트앨범();
        clazz.solution(
                new String[] { "classic", "pop", "classic", "classic", "pop" },
                new int[] { 500, 600, 150, 800, 2500 }
        );
    }
}
