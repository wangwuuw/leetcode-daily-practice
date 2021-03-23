package entity;

/**
 * @Author: wangwu
 * @Date: Created in 17:46 2020-03-18
 * @Description:
 */
public enum KycLevel {
	/**
	 * Users who fail to pass KYC
	 */
	UNVERIFIED,
	RETAIL,
	PROFESSIONAL,
	/**
	 * MARKET_COUNTERPARTY = 市场对手方
	 */
	MARKET_COUNTERPARTY
}
