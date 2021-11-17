package api.service;

import static api.service.URI.GET_CARDS_URL;
import static api.service.URI.GET_CARD_URL;
import static java.text.MessageFormat.format;

import api.dao.BoardDto;
import api.dao.CardDto;
import io.qameta.allure.Step;

public class CardsService extends TrelloService {

    @Step(value = "Create Card {0}")
    public CardDto createCard(CardDto cardDto) {
        return parser(getPostResponse(cardDto, GET_CARDS_URL), new CardDto());
    }

    @Step(value = "Get Card {0}")
    public CardDto getCard(String cardId) {
        return parser(getGetResponse(format(GET_CARD_URL, cardId)), new CardDto());
    }
    
    @Step(value = "Update Card {0}")
    public CardDto updateBoard(BoardDto boardDto, String cardId) {
        return parser(getPutResponse(boardDto, format(GET_CARD_URL, cardId)), new CardDto());
    }
    
    @Step(value = "Delete Card {0}")
    public void deleteCard(String cardId) {
        getDeleteResponse(format(GET_CARD_URL, cardId));
    }
}
